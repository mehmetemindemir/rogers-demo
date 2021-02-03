echo " Choose Project for deploy"
echo "1-)dev "
echo "2-)prod"
read result
if [ "$result" == "dev" ]; then
  mvn clean install -U
  docker build . -t dhub.mehmetemindemir.com/med/rogersdemo-api:T001
  docker push dhub.mehmetemindemir.com/med/rogersdemo-api:T001

elif [ "$result" == "prod" ]; then
  mvn clean install -U
  docker build . -t dhub.mehmetemindemir.com/med/rogersdemo-api:P001
  docker push dhub.mehmetemindemir.com/med/rogersdemo-api:P001
fi
