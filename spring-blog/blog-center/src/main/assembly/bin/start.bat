@echo off & setlocal enabledelayedexpansion

set LIB_JARS=""
cd ..\lib
for %%i in (*) do set LIB_JARS=!LIB_JARS!;..\lib\%%i
cd ..\bin

set DEPLOY_DIR="%~dp0.."
set LIB_DIR="%~dp0..\lib"

SET conf_file=%~dp0..\conf\hsbcs.properties

for /F "eol=# tokens=1,2 delims==" %%i in (!conf_file!) do (
if %%i == hsbcs.application.name set SERVER_NAME=%%j
if %%i == hsbcs.jetty.host set SERVER_HOST=%%j
if %%i == hsbcs.jetty.port set SERVER_PORT=%%j
if %%i == hsbcs.jmxport set SERVER_JMX_PORT=%%j
if %%i == hsbcs.debugport set SERVER_DEBUG_PORT=%%j
)

if "x%SERVER_PORT%" == "x" (
echo hsbcs.jetty.port is required!!!
pause
exit 1
)

if "x%SERVER_JMX_PORT%" == "x" (
set /a SERVER_JMX_PORT=%SERVER_PORT% + 3
)
if "x%SERVER_DEBUG_PORT%" == "x" (
set /a SERVER_DEBUG_PORT=%SERVER_PORT% + 4
)

set CLASS_PATH_PARAM=-Djna.library.path=%LIB_DIR% -classpath ..\conf;..\lib;%LIB_JARS%
set CLASS_PARAM=-Dhsbcs.home=%DEPLOY_DIR% -Dhsbcs.jetty.webappPath=..\webapp com.cloudbroker.bcs.common.server.JettyServer

if "%1" == "debug" goto debug
if "%1" == "jmx" goto jmx

java -Xms64m -Xmx1024m -XX:MaxPermSize=64M %CLASS_PATH_PARAM% %CLASS_PARAM%
goto end

:debug
java -Xms64m -Xmx1024m -XX:MaxPermSize=64M -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=%SERVER_DEBUG_PORT%,server=y,suspend=n %CLASS_PATH_PARAM% %CLASS_PARAM%
goto end

:jmx
java -Xms64m -Xmx1024m -XX:MaxPermSize=64M -Dcom.sun.management.jmxremote.port=%SERVER_JMX_PORT% -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false %CLASS_PATH_PARAM% %CLASS_PARAM%

:end
pause