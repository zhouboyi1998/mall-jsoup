<h1 align="center">🏪 mall-jsoup</h1>

<p align="center">
<a target="_blank" href="https://github.com/zhouboyi1998/mall-jsoup"> 
<img src="https://img.shields.io/github/stars/zhouboyi1998/mall-jsoup?logo=github">
</a>
<a target="_blank" href="https://opensource.org/licenses/MIT"> 
<img src="https://img.shields.io/badge/license-MIT-red"> 
</a>
<img src="https://img.shields.io/badge/JDK-1.8-darkcyan">
<img src="https://img.shields.io/badge/JSoup-1.10.2-blue">
</p>

### 📖 语言

简体中文 | [English](./README.en.md)

### ⌛ 开始

* 在 `jd.com` 网站中选择分类, 再输入关键词查询
* 将选择分类后 `jd.com` 网址最后拼接的 `cat` 参数，作为 `parse` 方法的第一个参数传入
* 将自己输入的 `keyword` 作为 `parse` 方法的第二个参数传入

#### 示例

```
parse("9987%2C653%2C655", "惠普");
```
