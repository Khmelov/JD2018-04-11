FOR %%I In (*.txt) DO (
start "" "C:\Program Files\Java\jdk1.8.0_171\bin\native2ascii"  -encoding UTF-8 %%I ..\lang\%%~nI.properties
)
