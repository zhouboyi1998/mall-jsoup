package com.cafe.jsoup.handler;

import cn.hutool.json.JSONUtil;
import com.cafe.jsoup.model.Goods;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: mall-jsoup
 * @Package: com.cafe.jsoup
 * @Author: zhouboyi
 */
public class DataHandler {

    /**
     * 组装数据 (可以直接将 List 数据存储到数据库中, 也可以转换成 JSON 格式用消息发送出去)
     *
     * @param lis
     */
    public static void getData(Elements lis, String category) {
        // 商品列表
        List<Goods> list = new ArrayList<Goods>();

        // 遍历获取每一个 li 标签中的数据
        for (Element li : lis) {
            // 商品对象
            Goods goods = new Goods();

            // 名称
            String name = li.getElementsByClass("p-name").eq(0).get(0).getElementsByTag("em").text();
            // 品牌
            String brand = "";
            if (li.getElementsByClass("p-shop").eq(0).size() > 0) {
                brand = li.getElementsByClass("p-shop").eq(0).get(0).text();
            } else if (li.getElementsByClass("p-shopnum").eq(0).size() > 0) {
                brand = li.getElementsByClass("p-shopnum").eq(0).get(0).text();
            }
            // 价格
            Double price = Double.parseDouble(li.getElementsByClass("p-price").eq(0).get(0).getElementsByTag("i").text());
            // 图片
            String image = li.getElementsByTag("img").eq(0).attr("data-lazy-img").substring(2);
            // 标题
            String caption = li.getElementsByClass("p-name").eq(0).get(0).getElementsByTag("i").text();

            // 输出到控制台 (不同类型的商品 HTML 结构可能不一样, 如果无法获取某一条数据, 可以对照 HTML 找出不同之处, 并编写 if else 兼容)
            System.out.println("\n==================================================\n");
            System.out.println(name);
            System.out.println(brand);
            System.out.println(price);
            System.out.println(image);
            System.out.println(caption);

            // 组装商品对象
            goods.setName(name);
            goods.setBrand(brand);
            goods.setCategory(category);
            goods.setPrice(price);
            goods.setImage(image);
            goods.setCaption(caption);

            // 添加到商品列表中
            list.add(goods);
        }

        // 转换为 JSON 字符串
        String json = JSONUtil.toJsonStr(list);
        System.out.println("\n==================================================\n");
        System.out.println(json);
    }
}
