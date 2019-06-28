; Crossmobile.nsi
;--------------------------------

!include "MUI2.nsh"

; The name of the installer
Name "CrossMobile"

; The file to write
OutFile "${CMINSTDESTDIR}\CrossMobile-${VERSION}.unsigned.exe"

; The default installation directory
InstallDir "$PROGRAMFILES64\CrossMobile"

; Registry key to check for directory (so if you install again, it will 
; overwrite the old one automatically)
InstallDirRegKey HKLM "Software\CrossMobile" "Install_Dir"


SetCompressor /SOLID lzma

;--------------------------------

!define MUI_BGCOLOR b8dfb8
!define MUI_ABORTWARNING
!define MUI_ICON "../resources/installers/windows/install.ico"
!define MUI_UNICON "../resources/installers/windows/install.ico"
!define MUI_WELCOMEFINISHPAGE_BITMAP "../resources/installers/windows/logo-install.bmp"
!define MUI_COMPONENTSPAGE_SMALLDESC

; Other parameters
LicenseForceSelection checkbox


;--------------------
; Pages

!define MUI_PAGE_CUSTOMFUNCTION_SHOW MyWelcomeShowCallback
!insertmacro MUI_PAGE_WELCOME
!insertmacro MUI_PAGE_LICENSE "${CMINSTDESTDIR}\LICENSE"
!insertmacro MUI_PAGE_COMPONENTS
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_INSTFILES
!insertmacro MUI_PAGE_FINISH

!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES

!insertmacro MUI_LANGUAGE "English"

;--------------------------------

Function MyWelcomeShowCallback
${NSD_CreateLabel} 120u 150u 50% 12u "A valid JDK 1.8 environment is required."
Pop $0
SetCtlColors $0 "" "${MUI_BGCOLOR}"
FunctionEnd



; The stuff to install
Section "CrossMobile" SecCrossMobileMain

  SectionIn RO
  
  ; Set output path to the installation directory.
  SetOutPath $INSTDIR
  File "${CMINSTDESTDIR}\CrossMobile.exe"
  File "${CMINSTDESTDIR}\LICENSE"

  ; Create library
  SetOutPath $INSTDIR\lib
  File /r ${CMINSTDESTDIR}\lib\*.*

  SetOutPath $INSTDIR\jre
  File /r ${CMINSTDESTDIR}\jre\*.*

  SetOutPath $INSTDIR

  SetRegView 64
  ; Write the installation path into the registry
  WriteRegStr HKLM "Software\CrossMobile" "Install_Dir" "$INSTDIR"
  
  ; Write the uninstall keys for Windows
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\CrossMobile" "DisplayName" "CrossMobile"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\CrossMobile" "UninstallString" '"$INSTDIR\uninstall.exe"'
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\CrossMobile" "QuietUninstallString" "$\"$INSTDIR\uninstall.exe$\" /S"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\CrossMobile" "Publisher" "CrossMobile.tech"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\CrossMobile" "DisplayIcon" "$INSTDIR\CrossMobile.exe,0"
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\CrossMobile" "EstimatedSize" 16582
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\CrossMobile" "NoModify" 1
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\CrossMobile" "NoRepair" 1
  WriteUninstaller "uninstall.exe"
  
SectionEnd


; Create Start menu shortcuts
;--------------------------------
Section "Start Menu Shortcuts" SecStartMenu
  SetShellVarContext all
  CreateDirectory "$SMPROGRAMS\CrossMobile"
  CreateShortCut "$SMPROGRAMS\CrossMobile\Uninstall.lnk" "$INSTDIR\uninstall.exe" "" "$INSTDIR\uninstall.exe" 0
  CreateShortCut "$SMPROGRAMS\CrossMobile\CrossMobile.lnk" "$INSTDIR\CrossMobile.exe" "" "$INSTDIR\CrossMobile.exe" 0
SectionEnd


; Create Desktop shortcuts
;--------------------------------
Section "Desktop Icon" SecDesktop
  SetShellVarContext all
  CreateShortCut "$DESKTOP\CrossMobile.lnk" "$INSTDIR\CrossMobile.exe" "" "$INSTDIR\CrossMobile.exe" 0
SectionEnd


;--------------------------------

LangString DESC_SecCrossMobileMain ${LANG_ENGLISH} "Required CrossMobile program files."
LangString DESC_SecStartMenu ${LANG_ENGLISH} "Add Start Menu Icons."
LangString DESC_SecDesktop ${LANG_ENGLISH} "Add Desktop Icon."


!insertmacro MUI_FUNCTION_DESCRIPTION_BEGIN
  !insertmacro MUI_DESCRIPTION_TEXT ${SecCrossMobileMain} $(DESC_SecCrossMobileMain)
  !insertmacro MUI_DESCRIPTION_TEXT ${SecStartMenu} $(DESC_SecStartMenu)
  !insertmacro MUI_DESCRIPTION_TEXT ${SecDesktop} $(DESC_SecDesktop)
!insertmacro MUI_FUNCTION_DESCRIPTION_END


;--------------------------------

; Uninstaller

Section "Uninstall"
  
  ; Remove registry keys
  SetRegView 64

  DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\CrossMobile"
  DeleteRegKey HKLM "Software\CrossMobile"

  ; Remove files and uninstaller
  RMDir /R "$INSTDIR"

  SetShellVarContext all

  ; Remove shortcuts, if any
  Delete "$SMPROGRAMS\CrossMobile\*.*"
  RMDir "$SMPROGRAMS\CrossMobile"

  ; Remove Desctop shortcut
  Delete "$DESKTOP\CrossMobile.lnk"

SectionEnd
