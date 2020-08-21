package hello_service_generic_golang

import (
	"context"
	"fmt"
	"sync/atomic"
	"time"

	hessian "github.com/apache/dubbo-go-hessian2"
	_ "github.com/apache/dubbo-go/cluster/cluster_impl"
	_ "github.com/apache/dubbo-go/cluster/loadbalance"
	_ "github.com/apache/dubbo-go/common/proxy/proxy_factory"
	"github.com/apache/dubbo-go/config"
	_ "github.com/apache/dubbo-go/filter/filter_impl"
	"github.com/apache/dubbo-go/protocol/dubbo"
	_ "github.com/apache/dubbo-go/registry/protocol"
	_ "github.com/apache/dubbo-go/registry/zookeeper"
)

var (
	genericService  *config.GenericService
	referenceConfig = &config.ReferenceConfig{
		InterfaceName: "com.github.wongoo.dubbo.hello.HelloService",
		Cluster:       "failover",
		Version:       "1.0.0",
		Protocol:      dubbo.DUBBO,
		Generic:       true,
	}
)

func ConfigReferenceConfigUrl(url string) {
	referenceConfig.Url = url
}

func ConfigReferenceConfigRegistry(registry string) {
	referenceConfig.Registry = registry
}

func loadGenericService() {
	// the unique identification of RPCService
	referenceConfig.GenericLoad("com.github.wongoo.dubbo.hello.HelloService")

	//time.Sleep(3 * time.Second)

	genericService = referenceConfig.GetRPCService().(*config.GenericService)
}

func sayHello() {
	// NOTICE: the third parameter must be a slice of hessian.Object,
	// so that the parameter type will be `[Ljava/lang/Object;`
	resp, err := genericService.Invoke(context.TODO(),
		[]interface{}{"sayHello", []string{"java.lang.String"}, []hessian.Object{"world"}})
	if err != nil {
		panic(err)
	}
	fmt.Printf("res: %+v\n", resp)
}

var (
	sequence int64
)

func exchange() {
	req := map[string]interface{}{
		"id":      atomic.AddInt64(&sequence, 1),
		"content": "hello golang generic",
		"time":    time.Now(),
	}

	resp, err := genericService.Invoke(context.TODO(),
		[]interface{}{"exchange", []string{"com.github.wongoo.dubbo.hello.Request"}, []hessian.Object{req}})
	if err != nil {
		panic(err)
	}
	fmt.Printf("res: %+v\n", resp)
}

// see start.sh
func GenericCall() {
	loadGenericService()

	for i := 0; i < 10; i++ {
		sayHello()
		exchange()
	}

	fmt.Println("finish!")
}
