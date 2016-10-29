//package com.example.yazhai1226.androidtest.utils;
//
//import android.view.Menu;
//
//import java.util.logging.Logger;
//
///**
// * Created by MingRen on 2016/3/23.
// */
//public class MenuManager {
//    private static Logger log = LoggerFactory.getLogger(MenuManager.class);
//
//    public static void main(String[] args) {
//        // 第三方用户唯一凭证
//        String appId = "自己的开发者APPID";
//        // 第三方用户唯一凭证密钥
//        String appSecret = "自己的APPSECRET";
//
//        // 调用接口获取access_token
//        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
//
//        if (null != at) {
//            // 调用接口创建菜单
//            int result = WeixinUtil.createMenu(getMenu(), at.getToken());
//
//            // 判断菜单创建结果
//            if (0 == result)
//                log.info("菜单创建成功！");
//            else
//                log.info("菜单创建失败，错误码：" + result);
//        }
//    }
//
//    /**
//     * 组装菜单数据
//     *
//     * @return
//     */
//    private static Menu getMenu() {
//        CommonButton btn11 = new CommonButton();
//        btn11.setName("官方网站");
//        btn11.setType("view");
//        btn11.setUrl("http://www.elve.cn");
//
//        CommonButton btn12 = new CommonButton();
//        btn12.setName("博文");
//        btn12.setType("click");
//        btn12.setKey("11");
//
//        CommonButton btn21 = new CommonButton();
//        btn21.setName("美文");
//        btn21.setType("click");
//        btn21.setKey("12");
//
//        CommonButton btn13 = new CommonButton();
//        btn13.setName("考勤记录");
//        btn13.setType("click");
//        btn13.setKey("13");
//
//        CommonButton btn33 = new CommonButton();
//        btn33.setName("公司公告");
//        btn33.setType("click");
//        btn33.setKey("33");
//
//        ComplexButton mainBtn1 = new ComplexButton();
//        mainBtn1.setName("关于公司");
//        mainBtn1.setSub_button(new CommonButton[]{btn11, btn12});
//
//        ComplexButton mainBtn2 = new ComplexButton();
//        mainBtn2.setName("考勤状况");
//        mainBtn2.setSub_button(new CommonButton[]{btn21});
//
//
//        /**
//         * 每个一级菜单都不一定必须有二级菜单项<br>
//         *
//         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
//         * 第三个一级菜单项是"公司公告"，那么menu应该这样定义：<br>
//         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
//         */
//        Menu menu = new Menu();
//        menu.setButton(new Button[]{mainBtn1, mainBtn2, btn33});
//
//        return menu;
//    }
//}
