base_dir=$(pwd)
export APP_LOG_CONF_FILE=$base_dir"/log.yml"
export CONF_CONSUMER_FILE_PATH=$base_dir"/client.yml"

go run main.go
