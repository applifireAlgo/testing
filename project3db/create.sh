




echo $PATH
OSNAME=`uname -s`
DB_PATH=/tmp/applifire/db/UIBLEIKUKGKZYF986GJTLA/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C
ART_CREATE_PATH=/tmp/applifire/db/UIBLEIKUKGKZYF986GJTLA/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/art/create
AST_CREATE_PATH=/tmp/applifire/db/UIBLEIKUKGKZYF986GJTLA/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C/ast/create
MYSQL=/usr/bin
APPLFIREUSER=root
APPLFIREPASSWORD=root
APPLFIREHOST=localhost

if [ $OSNAME == "Darwin" ]; then
echo "Setting up MYSQL PATH for OS $OSNAME"
MYSQL=/usr/local/mysql/bin/
fi



DB_NAME=project3
USER=project3
PASSWORD=project3
PORT=3306
HOST=localhost


echo 'grant previliges to user starts....'
$MYSQL/mysql -h$APPLFIREHOST -u$APPLFIREUSER -e "SOURCE $DB_PATH/grant_previliges.sql";
echo 'grant previliges to user ends....'

echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'

echo 'create db starts....'
$MYSQL/mysql -h$APPLFIREHOST -u$APPLFIREUSER -e "SOURCE $DB_PATH/create_db.sql";
echo 'create db ends....'

echo 'create ART table process starts...'


$MYSQL/mysql -h$HOST -p$PORT -u$USER -p$PASSWORD $DB_NAME -e "SOURCE $ART_CREATE_PATH/CreateArtTable.sql";echo 'create ART table process ends...'

echo 'create AST table process starts...'
$MYSQL/mysql --local-infile=1 -h$HOST -p$PORT -u$USER -p$PASSWORD $DB_NAME -e "SOURCE $AST_CREATE_PATH/createAstTable.sql"; 

echo 'create AST table process ends...'

