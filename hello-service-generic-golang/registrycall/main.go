package main

import (
	"hello-service-generic-golang"
)

// start the project hello-service-provider-zk first
//
// generic call dubbo service registered in zookeeper
func main() {
	hello_service_generic_golang.ConfigReferenceConfigRegistry("localzk")
	hello_service_generic_golang.GenericCall()
}
