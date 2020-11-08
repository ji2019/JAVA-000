**Week_04_02 作业题目：**

```
Week_04_02
第7节课作业实践
1、（选做）把示例代码，运行一遍，思考课上相关的问题。也可以做一些比较。
2、（必做）思考有多少种方式，在main函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？写出你的方法，越多越好，提交到github

后半场
1、（选做）列举常用的并发操作API的工具类，简单分析其使用场景和优缺点
2、（选做）请思考：什么是并发?什么是高并发?实现高并发高可用系统需要考虑哪些因素。对于这些你是怎么理解的?
3、（选做）请思考 还有哪些跟并发类似、有关的场景的问题。有哪些可以借鉴的解决办法。
4、（选做）把多线程和并发相关知识带你梳理一遍，画一个脑图，截图上传到github上

可选工具    xmind 百度脑图 wps 	MindManage , 或其他。
```

```
	public static void main(String[] args) {
		List<String> lisst = new ArrayList<String>();
		List<String> ss = new LinkedList<String>();
		List<String> vv = new Vector<String>();
		Collections.synchronizedCollection(lisst);
		//CopyOnWriteArrayList 内的  COWIterator
		List<String> cowa =  new CopyOnWriteArrayList<String>();
		// 空间换时间
		Map<String,Object> maps = new ConcurrentHashMap<String, Object>();
	}
```

