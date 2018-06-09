FOR %%I In (*.txt) DO (
native2ascii -encoding UTF-8 %%I ..\lang\%%~nI.properties
)