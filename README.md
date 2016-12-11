# RenameMultipleFiles
Simple java utility with the purpouse to rename files via shell
# Usage
> java -jar RenameMultipleFiles.jar (WORKING_DIR) (PATTERN_TO_FIND) (NEW_NAME)

# Example
tito@tito-1510:~/Tmp$ ll
  -rw-rw-r--  1 tito tito 1351078 ago 31 15:58 auguri.jpg
tito@tito-1510:~/Programmi$ java -jar RenameMultipleFiles.jar /home/tito/Tmp/ auguri Auguri
tito@tito-1510:~/Tmp$ ll
  -rw-rw-r--  1 tito tito 1351078 ago 31 15:58 Auguri.jpg
