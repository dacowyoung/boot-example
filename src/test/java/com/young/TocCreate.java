package com.young;

import com.github.houbb.markdown.toc.core.impl.AtxMarkdownToc;

/**
 * @author: young
 * @create: 2019/1/28 17:56
 * @desc: md文档目录生成
 */
public class TocCreate {

    public static void main(String[] args) {
        AtxMarkdownToc atxMarkdownToc = AtxMarkdownToc.newInstance()
                .charset("UTF-8")
                .write(true)
                .subTree(true);
        atxMarkdownToc.genTocFile("C:\\Users\\Administrator\\Desktop\\study\\boot-example\\README.md");

    }

}
