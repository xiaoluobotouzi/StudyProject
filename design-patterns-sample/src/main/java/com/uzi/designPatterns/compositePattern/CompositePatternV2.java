package com.uzi.designPatterns.compositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 组合模式 安全模式 -demo
 * @Author: LIU.KL
 * @Date: 2020/5/21
 * ...
 */
public class CompositePatternV2 {

    public static void main(String[] args) {

        File index = new File("index.html");
        File bak = new File("备份.txt");

        Folder devTool = new Folder("开发工具", 2);
        File eclipse = new File("eclipse.exe");
        File idea64 = new File("idea64.exe");
        File editPlus = new File("editPlus.exe");
        devTool.addFile(eclipse);
        devTool.addFile(idea64);
        devTool.addFile(editPlus);

        Folder dbTool = new Folder("数据库操作工具", 3);
        dbTool.addFile(new File("navicat.exe"));
        dbTool.addFile(new File("RedisDesktopManager.exe"));
        devTool.addFile(dbTool);

        Folder d = new Folder("D:", 1);
        d.addFile(index);
        d.addFile(bak);
        d.addFile(devTool);

        d.show();

    }
}

/**
 * 场景案例就是 电脑里的文件夹一个很典型的树形结构
 * 目录下有文件夹和文件，文件夹下又可以存放文件夹和文件
 * 文件夹就是树枝节点，文件就是叶子节点
 * 由于目录系统层次较少，文件夹（树枝节点）较稳定，文件就有很多类型了
 * 使用 安全组合模式 实现目录系统
 * + D盘
 *   +-开发工具
 *     +--eclipse.exe
 *     +--idea64.exe
 *     +--editPlus.exe
 *   +-备份.txt
 *   +-index.html
*/

// 抽象根目录
abstract class Directory{

    protected String name;

    public Directory(String name) {
        this.name = name;
    }

    abstract void show();
}

class Folder extends Directory{

    private List<Directory> dirs = new ArrayList<>();
    private Integer level;

    public Folder(String name, Integer level) {
        super(name);
        this.level = level;
    }

    public boolean addFile(Directory dir){
        return this.dirs.add(dir);
    }

    public boolean removeFile(Directory dir){
        return this.dirs.remove(dir);
    }

    public Directory getFile(int dir){
        return this.dirs.get(dir);
    }

    public void list(){
        for (Directory dir : dirs) {
            System.out.println(dir.name);
        }
    }

    @Override
    void show() {
        System.out.println(this.name);

        for (Directory directory : dirs){
            // 控制显示格式
            if(null != this.level){
                for (int i = 0; i < this.level; i++) {
                    System.out.print("  ");
                }
                for (int i = 0; i < this.level; i++) {
                    if(i == 0){
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            directory.show();
        }
    }
}

class File extends Directory{

    public File(String name) {
        super(name);
    }

    @Override
    void show() {
        System.out.println(this.name);
    }
}
