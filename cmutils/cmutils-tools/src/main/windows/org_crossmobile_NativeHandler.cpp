#include "org_crossmobile_NativeHandler.h"

#include <Windows.h>
#include <TlHelp32.h>

JNIEXPORT jlong JNICALL Java_org_crossmobile_NativeHandler_handlerToPid(JNIEnv * env, jclass cls, jlong handler) {
	return GetProcessId((void*)handler);
	return -1;
}


bool __fastcall KillProcessTree(DWORD myprocID, DWORD dwTimeout) {
	bool bRet = true;
	HANDLE hWnd;
	PROCESSENTRY32 pe;

	memset(&pe, 0, sizeof(PROCESSENTRY32));
	pe.dwSize = sizeof(PROCESSENTRY32);

	HANDLE hSnap = ::CreateToolhelp32Snapshot(TH32CS_SNAPPROCESS, 0);

	if (::Process32First(hSnap, &pe)) {
		BOOL bContinue = TRUE;
		// kill child processes
		while (bContinue) {
			if (pe.th32ParentProcessID == myprocID){
				KillProcessTree(pe.th32ProcessID, dwTimeout);
				/*
				HANDLE hChildProc = ::OpenProcess(PROCESS_ALL_ACCESS, FALSE, pe.th32ProcessID);
				if (hChildProc) {
					GetWindowThreadProcessId(hWnd, &myprocID);
					// CLOSE Message s
					PostMessage(hWnd, WM_CLOSE, 0, 0);

					if (WaitForSingleObject(hChildProc, dwTimeout) == WAIT_OBJECT_0)
						bRet = true;
					else
					{
						bRet = TerminateProcess(hChildProc, 0);
					}
					::CloseHandle(hChildProc);
				} */
			}
			bContinue = ::Process32Next(hSnap, &pe);
		}
		HANDLE hProc = ::OpenProcess(PROCESS_ALL_ACCESS, FALSE, myprocID);
		if (hProc) {
			::TerminateProcess(hProc, 1);
			::CloseHandle(hProc);
		}
	}
	return bRet;
}

JNIEXPORT void JNICALL Java_org_crossmobile_NativeHandler_kill(JNIEnv * env, jclass cls, jlong pid) {
	KillProcessTree(pid, 0);

}