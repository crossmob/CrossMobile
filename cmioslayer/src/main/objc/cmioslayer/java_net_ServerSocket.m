/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#include <sys/socket.h> // for socket(), bind(), connect(), recv(), send() and accept()
#include <arpa/inet.h>  // for sockaddr_in and inet_ntoa()
#include <unistd.h>     // for close()
#include <sys/time.h>   // for timeval used in setsockopt with option name SO_RCVTIMEO

#import "java_io_IOException.h"
#import "java_net_ServerSocket.h"
#import "java_net_Socket.h"
#import "java_net_SocketTimeoutException.h"


// java.net.ServerSocket
//----------------------------------------------------------------------------
@implementation java_net_ServerSocket

/*
static void setnonblocking(int sock)
{
	int opts = fcntl(sock,F_GETFL);
	if (opts < 0) {
		perror("fcntl(F_GETFL)");
		exit(EXIT_FAILURE);
	}
	opts = (opts | O_NONBLOCK);
	if (fcntl(sock,F_SETFL,opts) < 0) {
		perror("fcntl(F_SETFL)");
		exit(EXIT_FAILURE);
	}
	return;
}
*/

- (instancetype) __init_java_net_ServerSocket__
{
    return [self init];
}

- (instancetype) __init_java_net_ServerSocket___int :(int) port
{
	return [self __init_java_net_ServerSocket___int_int:port:50];
}

- (instancetype) __init_java_net_ServerSocket___int_int :(int) port:(int) backlog
{
	soTimeout = 0;

	int maxpending = backlog;
	struct sockaddr_in echoServAddr; // Local address

	// Create socket for incoming connections
	if ((sock = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) < 0) {
		java_io_IOException* ex = [[java_io_IOException alloc] init];
		NSMutableString* str = [[NSMutableString alloc] initWithString:@"socket() failed"];
		[ex __init_java_io_IOException___java_lang_String:str];
		[str release];
		@throw ex;
	}

	int reuse_addr = 1; // Used so we can re-bind to our port while a previous connection is still in TIME_WAIT state.
	// So that we can re-bind to it without TIME_WAIT problems
	setsockopt(sock, SOL_SOCKET, SO_REUSEADDR, &reuse_addr, sizeof(reuse_addr));

	// According to http://www.lowtek.com/sockets/select.html - call the following, but it doesn't seem right to do
	//setnonblocking(sock);

	// Construct local address structure
	memset(&echoServAddr, 0, sizeof(echoServAddr));   // Zero out structure
	echoServAddr.sin_family = AF_INET;                // Internet address family
	echoServAddr.sin_addr.s_addr = htonl(INADDR_ANY); // Any incoming interface
	echoServAddr.sin_port = htons((unsigned short)port); // Local port

	// Bind to the local address
	if (bind(sock, (struct sockaddr *) &echoServAddr, sizeof(echoServAddr)) < 0) {
		java_io_IOException* ex = [[java_io_IOException alloc] init];
		NSMutableString* str = [[NSMutableString alloc] initWithString:@"bind() failed"];
		[ex __init_java_io_IOException___java_lang_String:str];
		[str release];
		@throw ex;
	}

	// Mark the socket so it will listen for incoming connections
	if (listen(sock, maxpending) < 0) {
		java_io_IOException* ex = [[java_io_IOException alloc] init];
		NSMutableString* str = [[NSMutableString alloc] initWithString:@"listen() failed"];
		[ex __init_java_io_IOException___java_lang_String:str];
		[str release];
		@throw ex;
	}
    return self;
}

- (void) setSoTimeout___int :(int) timeout
{
	soTimeout = timeout;
}

/**
 * @return the client socket descriptor or -1 on error
 */
static int acceptSocket(int sock, struct sockaddr_in * echoClntAddr)
{
	int clntSock = -1; // Socket descriptor for the client
	unsigned int clntLen = sizeof(echoClntAddr); // Length of client address data structure
	clntSock = accept(sock, (struct sockaddr *) &echoClntAddr, &clntLen);
	return clntSock;
}

- (java_net_Socket*) accept__
{
	int clntSock = -1;               // Socket descriptor for the client
	struct sockaddr_in echoClntAddr; // Client address

	BOOL error = FALSE;

	if (soTimeout == 0) {
		clntSock = acceptSocket(sock, &echoClntAddr);
	} else {
		fd_set socks; // Socket file descriptors we want to wake up for, using select()

		// clear out the fd_set called socks, so that it doesn't contain any file descriptors
		FD_ZERO(&socks);

		// Add the file descriptor "sock" to the fd_set, so that select() will return if a connection
		//   comes in on that socket, which means you have to accept(), etc.
		FD_SET(sock, &socks);

		struct timeval timeout;
		timeout.tv_sec = soTimeout / 1000;
		timeout.tv_usec = (soTimeout % 1000) * 1000; // tv_usec is the number of microseconds and is always less than one million

		// For more info on select(), see http://www.lowtek.com/sockets/select.html

		int readsocks = select(sock + 1, &socks, (fd_set *) 0, (fd_set *) 0, &timeout);
		if (readsocks < 0) {
			NSLog(@"select() failed");
			error = TRUE;
		} else if (readsocks > 0) {
			if (FD_ISSET(sock, &socks)) {
				clntSock = acceptSocket(sock, &echoClntAddr);
			} else {
				// Something is readable and it wasn't an incoming connection.
				// That is not expected since nothing else was added earlier via FD_SET.
				NSLog(@"An unexpected socket has been returned as readable");
				error = TRUE;
			}
		} else {
			//NSLog(@"No clients attempted to connect before the timeout");
			java_net_SocketTimeoutException* ex = [[java_net_SocketTimeoutException alloc] init];
			[ex __init_java_net_SocketTimeoutException__];
			@throw ex;
		}
	}

	if (!error) {
		if (clntSock < 0) {
			NSLog(@"accept() failed");
			error = TRUE;
		} else {
			// According to http://www.lowtek.com/sockets/select.html - call the following, but it doesn't seem right to do
			//setnonblocking(sock);

			// If we wanted to reject the connection due to limit, we could do something like the following
			//sock_puts(clntSock,"Sorry, this server is too busy. Try again later!\r\n");
			//close(clntSock);
		}
	}

	if (error) {
		java_io_IOException* ex = [[java_io_IOException alloc] init];
		[ex __init_java_io_IOException__];
		@throw ex;
	}

	// clntSock is connected to a client

	//printf("Handling client %s\n", inet_ntoa(echoClntAddr.sin_addr));

	return [[java_net_Socket alloc]initWithSocket:clntSock];
}


- (void) close__
{
	if (sock >= 0) {
		close(sock);
	}
}

@end
