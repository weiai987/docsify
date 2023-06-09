﻿
# 图书管理后台接口文档
> 基准路径： http://localhost:3000/

## 获取图书列表数据
- 路径：books
- 请求参数：无
- 响应结果

```json
[{
  "id": "4",
  "name": "红楼梦",
  "date": 2525609975000
}, {
  "name": "三国演义",
  "date": 2525609975000,
  "id": 5
}, {
  "name": "水浒传",
  "date": 2525609975000,
  "id": 6
}, {
  "name": "西游记",
  "date": 2525609975000,
  "id": 7
}]
```

## 添加图书-提交图书信息
- 路径：books
- 请求参数
    + name : 图书名称
- 响应结果

```json
{
    "status": 200  // (200表示成功；500表示失败)
}
```

## 编辑图书-根据ID查询图书信息
- 路径：books/:id
- 请求参数：无
- 响应结果

```json
{
    "name":"西游记",
    "date":2525609975000,
    "id":7
}
```

## 编辑图书-提交图书信息
- 路径：books/:id
- 请求参数
    + name : 图书名称
- 响应结果

```json
{
    "status": 200  // (200表示成功；500表示失败)
}
```

## 删除图书信息
- 路径：books/:id
- 请求参数: 无
- 响应结果

```json
{
    "status": 200  // (200表示成功；500表示失败)
}
```

## 验证图书名称是否存在
- 路径：books/book/:name
- 请求参数:无
- 响应结果

```json
{
    "status": 1  // (1表示存在；2表示不存在)
}
```

