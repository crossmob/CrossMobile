/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.Manifest;

@SuppressWarnings({"deprecated", "deprecation"})
public class AndroidPermission {
    //CALENDAR
    public final static String READ_CALENDAR = Manifest.permission.READ_CALENDAR;
    public final static String WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR;
    //CAMERA
    public final static String CAMERA = Manifest.permission.CAMERA;
    //CONTACTS
    public final static String READ_CONTACTS = Manifest.permission.READ_CONTACTS;
    public final static String WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
    public final static String GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
    //LOCATION
    public final static String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public final static String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    //MICROPHONE
    public final static String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
    //PHONE
    public final static String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public final static String CALL_PHONE = Manifest.permission.CALL_PHONE;
    public final static String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    public final static String WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;
    public final static String ADD_VOICEMAIL = Manifest.permission.ADD_VOICEMAIL;
    public final static String USE_SIP = Manifest.permission.USE_SIP;
    public final static String PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;
    //SENSORS
    public final static String BODY_SENSORS = Manifest.permission.BODY_SENSORS;
    //SMS
    public final static String SEND_SMS = Manifest.permission.SEND_SMS;
    public final static String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    public final static String READ_SMS = Manifest.permission.READ_SMS;
    public final static String RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH;
    public final static String RECEIVE_MMS = Manifest.permission.RECEIVE_MMS;
    //STORAGE
    public final static String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public final static String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public final static String USE_FINGERPRINT = Manifest.permission.USE_FINGERPRINT;

}
