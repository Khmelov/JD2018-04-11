FOR %%I in (*.txt) DO (
native2ascii -encoding UTF-8 %%I ..\lang\%%~nI.properties)
