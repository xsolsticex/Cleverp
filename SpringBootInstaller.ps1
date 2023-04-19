if (-Not ([Security.Principal.WindowsPrincipal][Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole([Security.Principal.WindowsBuiltInRole]::Administrator)) {
    if ([int](Get-CimInstance -Class Win32_OperatingSystem | Select-Object -ExpandProperty BuildNumber) -ge 6000) {
        Start-Process PowerShell -Verb RunAs -ArgumentList "-NoProfile -ExecutionPolicy Bypass -Command `"cd '$pwd'; & '$PSCommandPath';`"";
        
        Exit;
    }
}

$VerbosePreference = 'SilentlyContinue'
$ErrorActionPreference = 'Continue'
$folderName = "SpringbootInstaller"
$user = $env:USERNAME
$ProgressPreference='SilentlyContinue'




$netbeans = 'https://dlcdn.apache.org/netbeans/netbeans-installers/17/Apache-NetBeans-17-bin-windows-x64.exe'

$sprinbotPlugin = 'https://plugins.netbeans.apache.org/catalogue/download/175/nb-springboot-plugin-3.1.nbm'
$git = 'https://github.com/git-for-windows/git/releases/download/v2.39.2.windows.1/Git-2.39.2-64-bit.exe'

function Requirements{

    try{
        Write-Host 'Creating Folder'
        New-Item -Path 'SpringbootInstaller' -ItemType Directory

    }catch{
        Write-Output "Cannot create folder"
    
    }

try{
    $netbeansPath = Get-ChildItem "C:\Program Files" -Include "netbeans*" -Recurse -ErrorAction SilentlyContinue
    if($netbeansPath.Count -gt 0) {
        Write-Host "NetBeans está instalado"
    } else {
        Write-Host 'Download Netbeans'
        Invoke-WebRequest -Uri $netbeans -OutFile $folderName/Apache-NetBeans-17-bin-windows-x64.exe
    }
} catch {
    Write-Output "Error Downloading Netbeans"
}

    try{
    if(Test-Path $folderName/nb-springboot-plugin-3.1.nbm) {
    Write-Host "El archivo existe"
} else {
       Write-Host 'Download Springbot Plugin'
    Invoke-WebRequest -Uri $sprinbotPlugin  -OutFile $folderName/nb-springboot-plugin-3.1.nbm
}

    }catch{
        Write-Output "Error downloading Springbot plugin"
    }

    try{
    $java = 'https://download.oracle.com/java/17/archive/jdk-17.0.6_windows-x64_bin.exe'
    if(java -version 2>&1 | Out-String -Stream | Select-String "java version") {
    Write-Host "Java está instalado"
} else {
    
    
}

    }catch{
        Write-Host 'Download JDK 17'
    Invoke-WebRequest -Uri $java  -OutFile $folderName/jdk-17.0.6_windows-x64_bin.exe
    
    }

    try{
    if(git --version 2>&1 | Out-String -Stream | Select-String "git version") {
    Write-Host "Git está instalado"
} else {
   
}


    
    }catch{
         Write-Host 'Download Git'
    Invoke-WebRequest -Uri $git -OutFile $folderName/Git-2.39.2-64-bit.exe
    }
}

function Installer{

    ##################################################################
    try{
    Write-Host 'Starting Java Installer...'
    Start-Process $folderName/jdk-17.0.6_windows-x64_bin.exe -ArgumentList "/s"
    }
    catch{
        Write-Output "Java Installer Cancelled"
    }

    ##################################################################

    try{
    $arguments = "/SILENT"
    $arguments +=" /NORESTART"
    $argumens +=" /COMPONENTS='icons,ext\reg\shellhere,assoc_sh'"
    $arguments +=" /DIR='C:\Program Files\Git'"
    $arguments += " /GROUP='Git'"
    
        Write-Host 'Starting Git Installer'
        Start-Process $folderName/Git-2.39.2-64-bit.exe -ArgumentList $arguments -Wait
    }catch{
        Write-Output "Git Installer cancelled"
    }
    
   ################################################################## 
    try{
    $arguments="--silent"
    $arguments+=" --nogui"
    $arguments+=" --no-default"
    $arguments+=" --nospacecheck"
    $arguments+=" --javahome `"$env:ProgramFiles\Java\jdk-17`""
    $arguments+=" --installdir `"$env:ProgramFiles\Netbeans\Netbeans 17`""
    $arguments+=" --nb-base-uri `"$env:ProgramFiles\Netbeans\Netbeans 17`""

        Write-Host 'Starting Netbeans Installer'
        Start-Process $folderName/Apache-NetBeans-17-bin-windows-x64.exe -ArgumentList $arguments -Wait
    }catch{
        Write-Output "Netbeans Installer cancelled"
    
    }

    ################################################################

try {
    if(Test-Path -Path C:\Users\$user\AppData\Roaming\NetBeans\17\modules) {
        Write-Host "El archivo existe"
    } else {
        Write-Host 'Folder does not exist'
        New-Item -Path C:\Users\$user\AppData\Roaming\NetBeans\17\modules -ItemType Directory
    }
    Copy-Item -Path "$folderName\nb-springboot-plugin-3.1.nbm" -Destination C:\Users\$user\AppData\Roaming\NetBeans\17\modules\nb-springboot-plugin-3.1.nbm 
}
catch {
    Write-Output "Error: $_"
}

    ###################################################################

}


function Repository{

try{
#Set-Location $folderName

    $repository = Read-Host 'Repository to clone '

}catch{

}

    git clone $repository

    

}


Requirements
Installer
Repository
$progressPreference = 'Continue'
pause