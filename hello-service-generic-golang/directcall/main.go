package main

import (
	"hello-service-generic-golang"
)

func main() {
	// start the project hello-service-provider-zk first
	// directly generic call dubbo service for special address
	hello_service_generic_golang.ConfigReferenceConfigUrl("dubbo://127.0.0.1:12346")
	hello_service_generic_golang.GenericCall()
}
