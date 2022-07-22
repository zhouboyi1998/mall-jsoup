package com.cafe.jsoup;

import com.cafe.jsoup.handler.DataHandler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.net.URLDecoder;

/**
 * @Project: mall-jsoup
 * @Package: com.cafe.jsoup
 * @Author: zhouboyi
 */
public class JsoupEntry {

    /**
     * 解析 HTML
     *
     * @param cat
     * @param keyword
     */
    private static void parse(String cat, String keyword) {
        try {
            // jd.com 搜索页
            String url = "https://list.jd.com/list.html?cat=" + cat + "&keyword=" + keyword;
            // 解析成 UTF-8 格式 (支持 URL 中携带中文)
            String decode = URLDecoder.decode(url, "UTF-8");

            // 解析网页, 获取浏览器 Document 对象
            Document document = Jsoup.parse(new URL(decode), 50000);

            // 获取第三个 class="crumbs-nav-item" 的 div (第三级分类)
            String three = document.getElementsByClass("crumbs-nav-item").eq(2).get(0).text();
            // 获取到的字符串可以按空格切分成数组, 获取第一个元素作为分类名称
            String category = three.split(" ")[0];
            // 输出分类名称
            System.out.println("\n==================================================\n");
            System.out.println(category);

            // 获取 id = "J_goodsList" 的 div (商品列表)
            Element root = document.getElementById("J_goodsList");
            // 输出商品列表 div, 用于调试
            System.out.println("\n==================================================\n");
            System.out.println(root);
            // 获取所有 class="gl-item" 的 li 标签 (每一个商品的信息)
            Elements lis = root.getElementsByClass("gl-item");

            // 组装数据
            DataHandler.getData(lis, category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parse("9987%2C653%2C655", "惠普");
    }
}
