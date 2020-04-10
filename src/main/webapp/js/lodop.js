var LODOP;
$("#testLodop").click(function(){
    LODOP=getLodopAlert();
    LODOP.PRINT_INIT("打印插件功能演示_代码功能_名片");
    //初始化并指定打印任务名是"打印插件功能演示_代码功能_名片"
    alert("123");
    LODOP.ADD_PRINT_RECT(10,55,360,220,0,1);
    //边框离纸张顶端10px(px是绝对值长度，等于1/96英寸,下同)距左边55px、宽360px、高220px、
    // 框为实线(0-实线 1-破折线 2-点线 3-点划线 4-双点划线)、线宽为1px
    LODOP.SET_PRINT_STYLE("FontSize",11);
    //"FontSize"是系统关键字，表示设置字体大小，11是字体大小值，单位是pt。
    LODOP.SET_SHOW_MODE('LANDSCAPE_DEFROTATED',1);
    //横向时的正向显示
    LODOP.SET_PRINT_PAGESIZE (2,0,0,'A4');
    //SET_PRINT_PAGESIZE(intOrient,intPageWidth,intPageHeight,strPageName);
    // 参数含义：
    // intOrient：打印方向及纸张类型。值为1---纵向打印，固定纸张；值为2---横向打印，固定纸张；值为3---纵向打印，宽度固定，高度按打印内容的高度自适应；0(或其它)----打印方向由操作者自行选择或按打印机缺省设置。
    //intPageWidth：纸张宽，单位为0.1mm 譬如该参数值为45，则表示4.5mm,计量精度是0.1mm。
    // intPageHeight：固定纸张时该参数是纸张高；高度自适应时该参数是纸张底边的空白高，计量单位与纸张宽一样。
    // strPageName：纸张名，必须intPageWidth等于零时本参数才有效，有如下选择：
    // Letter, LetterSmall, Tabloid, Ledger, Legal,Statement, Executive, A3, A4, A4Small, A5, B4, B5, Folio, Quarto, qr10X14, qr11X17, Note,  Env9, Env10, Env11, Env12,Env14, Sheet, DSheet, ESheet
    LODOP.SET_PRINT_STYLEA(2,"FontName","隶书");
    LODOP.SET_PRINT_STYLEA(2,"FontSize",15);
    //2是姓名栏的增加顺序号,"FontName"和"FontSize"是系统关键字,表示设置字体名和字体大小。
    // "隶书"是字体名值,同操作系统的字体名，15是字体大小值，单位是pt。
    // 序号设0表示最新对象，注意SET_PRINT_STYLEA与SET_PRINT_STYLE的区别。

    //方式一 start：如下  分别设置每个输出的打印项和内容
    /*LODOP.ADD_PRINT_TEXT(20,180,100,25,"郭德强");
    LODOP.ADD_PRINT_TEXT(53,187,75,20,"科学家");
    LODOP.ADD_PRINT_TEXT(100,131,272,20,"地址：中国北京社会科学院附近东大街西胡同");
    LODOP.ADD_PRINT_TEXT(138,132,166,20,"电话：010-88811888");*/
    //方式一  end
    //===================================================================================================//
    //方式二 start
    var strHtml = "<table border=\"1\" width=\"360\" height=\"220\" style=\"border-collapse:collapse;border:solid 1px\" bordercolor=\"#000000\">\n" +
        "  <tr>\n" +
        "    <td width=\"100%\" height=\"240\">\n" +
        "      <p align=\"center\"> \n" +
        "      <font face=\"隶书\" size=\"5\" style=\"letter-spacing: 10px\">郭德强</font>\n" +
        "      <p align=\"center\"><font face=\"宋体\" size=\"3\">科学家</font></p>\n" +
        "      <p align=\"left\"><font face=\"宋体\" size=\"3\">　地址：中国北京社会科学院附近东大街西胡同</font></p>\n" +
        "      <p align=\"left\"><font face=\"宋体\" size=\"3\">　电话：010-88811888</font></p>\n" +
        "      <p><br>      　\n" +
        "      </p>\n" +
        "    </td>\n" +
        "  </tr>\n" +
        "</table>";
    LODOP.ADD_PRINT_HTM(10,55,"100%","100%",strHtml);
    //方式二  end

    LODOP.PREVIEW();
})