package main

import (
	"context"
	"fmt"
	"time"

	_ "github.com/apache/dubbo-go/cluster/cluster_impl"
	_ "github.com/apache/dubbo-go/cluster/loadbalance"
	_ "github.com/apache/dubbo-go/common/proxy/proxy_factory"
	"github.com/apache/dubbo-go/config"
	_ "github.com/apache/dubbo-go/filter/filter_impl"
	"github.com/apache/dubbo-go/protocol/dubbo"
	_ "github.com/apache/dubbo-go/registry/protocol"
	_ "github.com/apache/dubbo-go/registry/zookeeper"
)

func main() {
	var referenceConfig = config.ReferenceConfig{
		InterfaceName: "com.github.wongoo.dubbo.hello.HelloService",
		Cluster:       "failover",
		Registry:      "localzk",
		Version:       "1.0.0",
		Protocol:      dubbo.DUBBO,
		Generic:       true,
	}

	var appName = "HelloServiceGolangGeneric"
	referenceConfig.GenericLoad(appName) //appName is the unique identification of RPCService

	time.Sleep(3 * time.Second)

	fmt.Println("start to generic invoke")
	resp, err := referenceConfig.GetRPCService().(*config.GenericService).Invoke(context.TODO(),
		[]interface{}{"sayHello", []string{"java.lang.String"}, []interface{}{"world"}})
	if err != nil {
		panic(err)
	}
	fmt.Printf("res: %+v\n", resp)
	fmt.Println("success!")

}
