# Data-Analysis
FileUtil类用来读文件<br>

DataUtil类用来解析数据<br>

data1.txt为数据文件，记录了4年熊市15分钟级别的K线数据<br>
test1.txt为测试文件，一共只有12条15分钟级别的K线数据，用来验算公式代码<br><br>

直接调用
DataUtil.dataHandler(FileUtil.dataReader("data1.txt")); <br>
FileUtil读取数据以后传给DataUtil类解析，返回值是一组Data类的List<br>

Data类对象包含Timestamp, open, close, high, low, volume。 分别对应unix时间戳，开市价，收市价，最高价，最低价和成交量。这些变量均可使用get和set方法。 <br>

完整打印data1.txt里所有收市价的例子为：<br>
List<Data> dataList = DataUtil.dataHandler(FileUtil.dataReader("data1.txt")); <br>
for(Data tempData: dataList){ <br>
  System.out.println(tempData.getClose()); <br>
}<br>
