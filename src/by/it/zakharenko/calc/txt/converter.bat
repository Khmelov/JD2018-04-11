FOR %%I In (*.txt) DO (
"C:\Program Files\Java\jdk1.8.0_161\bin\native2ascii" -encoding UTF-8 %%I ..\lang\%%~nI.properties
)
