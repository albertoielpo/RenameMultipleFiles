# RenameMultipleFiles
Simple java utility with the purpouse to rename files via shell
Usage:
> java -jar RenameMultipleFiles.jar (WORKING_DIR) (PATTERN_TO_FIND) (NEW_NAME)

Example
tito@tito-1510:~/Programmi$ java -jar RenameMultipleFiles.jar /home/tito/Tmp/ auguri Auguri
Start: Sun Dec 11 16:15:27 CET 2016
Preview
-------
New name: /home/tito/Tmp/Auguri.jpg
No action: /home/tito/Tmp/linux_notes.html
No action: /home/tito/Tmp/local
No action: /home/tito/Tmp/usb
No action: /home/tito/Tmp/diff
No action: /home/tito/Tmp/cosaVorreiFare
No action: /home/tito/Tmp/index.html
No action: /home/tito/Tmp/ex1
No action: /home/tito/Tmp/ex2
No action: /home/tito/Tmp/linux_notes.lyx
# Files: 10
# No action files: 9
# New name files: 1
-------
Do you want to continue? [y/n]
y
No action files: 9
New name files: 1
End: Sun Dec 11 16:15:30 CET 2016
tito@tito-1510:~/Tmp$ ll
totale 2088
drwxrwxr-x  3 tito tito    4096 dic 11 16:15 ./
drwxr-xr-x 53 tito tito    4096 dic 11 15:08 ../
-rw-rw-r--  1 tito tito 1351078 ago 31 15:58 Auguri.jpg
-rw-rw-r--  1 tito tito     473 dic 11 04:29 cosaVorreiFare
-rw-rw-r--  1 tito tito   47729 ago  2 05:54 diff
-rw-rw-r--  1 tito tito   28378 dic 10 21:37 ex1
-rw-rw-r--  1 tito tito   28381 dic 10 21:49 ex2
-rw-rw-r--  1 tito tito  116163 lug 27 16:42 index.html
-rw-rw-r--  1 tito tito   66627 giu 25 15:29 linux_notes.html
-rw-rw-r--  1 tito tito   62371 giu 25 15:28 linux_notes.lyx
-rw-rw-r--  1 tito tito  216935 ago  2 05:49 local
-rw-rw-r--  1 tito tito  186396 ago  2 05:49 usb
