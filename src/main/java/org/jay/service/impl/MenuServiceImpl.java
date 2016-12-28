package org.jay.service.impl;

import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.jay.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxMpService wxService;

    @Override
    public void createMenu() {
        // 设置菜单
        WxMenu wxMenu = new WxMenu();
        String a = "{\n"
                + "  \"menu\": {\n"
                + "    \"button\": [\n"
                + "      {\n"
                + "        \"type\": \"click\",\n"
                + "        \"name\": \"今日推广\",\n"
                + "        \"key\": \"V1001_TODAY_MUSIC\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"type\": \"click\",\n"
                + "        \"name\": \"我要充值\",\n"
                + "        \"key\": \"V1001_TODAY_SINGER\"\n"
                + "      },\n"
                + "      {\n"
                + "        \"name\": \"菜单\",\n"
                + "        \"sub_button\": [\n"
                + "          {\n"
                + "            \"type\": \"view\",\n"
                + "            \"name\": \"搜索\",\n"
                + "            \"url\": \"http://www.soso.com/\"\n"
                + "          },\n"
                + "          {\n"
                + "            \"type\": \"view\",\n"
                + "            \"name\": \"视频\",\n"
                + "            \"url\": \"http://v.qq.com/\"\n"
                + "          },\n"
                + "          {\n"
                + "            \"type\": \"click\",\n"
                + "            \"name\": \"赞一下我们\",\n"
                + "            \"key\": \"V1001_GOOD\"\n"
                + "          }\n"
                + "        ]\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}";

        try {
            logger.info(wxMenu.fromJson(a).toJson());
            wxService.getMenuService().menuCreate(wxMenu.fromJson(a));
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }
}
