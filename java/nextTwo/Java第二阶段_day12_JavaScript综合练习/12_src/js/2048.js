//创建一个game对象，游戏所有的属性和方法都放在game对象中
var game = {
    data: [], //添加一个属性，用于存储游戏数据
    score: 0, //添加一个得分的属性
    status: 1, //添加一个游戏状态
    gameover: 0, //添加一个游戏结束状态
    gamerunning: 1, //添加一个游戏运行状态
    start: function () { //添加一个开始游戏的方法
        this.status = this.gamerunning; //游戏的状态为游戏运行的状态
        this.score = 0; //重置游戏的得分为0
        this.data = []; //清空游戏的数组
        for (var r = 0; r < 4; r++) {
            this.data[r] = []; //创建四行
            for (var c = 0; c < 4; c++) {
                this.data[r][c] = 0; //每行创建四个元素赋值为0
            }
        }
        this.randomNum(); //生成随机数方法，生成第一个
        this.randomNum(); //生成随机数方法，生成第二个
        this.dataView(); //更新视图
    },
    randomNum: function () { //随机生成空位置和随机生成2或者4
        for (;;) { //死循环   直到生成跳出循环
            var r = Math.floor(Math.random() * 4); //随机生成一个行
            var c = Math.floor(Math.random() * 4); //随机生成一个列
            if (this.data[r][c] == 0) { //随机生成的位置如果为0
                var num = Math.random() > 0.5 ? 2 : 4; //随机生成2或者4保存到num变量中
                this.data[r][c] = num; //为数组赋值
                break; //退出循环
            }
        }
    },
    dataView: function () { //数据显示到页面的方法
        for (var r = 0; r < 4; r++) { //遍历data
            for (var c = 0; c < 4; c++) {
                //每一个素组元素对应每一个div
                var div = document.getElementById("c" + r + c);
                if (this.data[r][c] != 0) { //数组的值如果不等于0
                    div.innerHTML = this.data[r][c]; //修改div的值
                    div.className = "cell n" + this.data[r][c]; //div的样式设置为cell 和对应的样式
                } else { //数组的值如果等于0
                    div.innerHTML = ""; //div的内容设置成空
                    div.className = "cell"; //div的样式设置为cell
                }
            }
        }
        //找到分数的ID，设置分数
        document.getElementById("score01").innerHTML = this.score;

        if (this.status == this.gameover) { //游戏状态等于游戏结束状态
            document.getElementById("score02").innerHTML = this.score; //游戏结束时候的分数显示	
            document.getElementById("gameover").style.display = "block"; //结束游戏的弹框显示
        } else {
            document.getElementById("gameover").style.display = "none"; //运行状态为1即游戏运行状态的时候结束游戏的弹框始终为隐藏
        }
    },
    isgameover: function () { //判断游戏结束的方法
        for (var r = 0; r < 4; r++) {
            for (var c = 0; c < 4; c++) {
                if (this.data[r][c] == 0) { //有等于0的返回false
                    return false;
                }
                if (c < 3) { //检查右侧相邻
                    if (this.data[r][c] == this.data[r][c + 1]) {
                        return false;
                    }
                }
                if (r < 3) { //检查下方相邻
                    if (this.data[r][c] == this.data[r + 1][c]) {
                        return false;
                    }
                }
            }
        } //遍历结束
        return true; //否则就返回true
    },
    moveLeft: function () {
        var before = String(this.data); //移动前为数组拍照
        // console.log(before)
        for (var r = 0; r < 4; r++) { //遍历每一行
            this.moveLeftinRow(r); //左移第r行
        }
        var after = String(this.data); //移动后为数组拍照
        if (before != after) { //如果移动前不等于移动后
            this.randomNum(); //生成一个随机数
            if (this.isgameover()) { //如果游戏结束
                this.status = this.gameover; //游戏状态更改为结束状态
            }
            this.dataView(); //数据更新
        }
    },
    moveLeftinRow: function (r) { //仅左移第r行
        for (var c = 0; c < 3; c++) { //最左边的不需要考虑,所以遍历3次
            //查找r行c位置后面不为0的位置保存到一个变量中
            var nextc = this.getNextinRow(r, c);

            if (nextc != -1) { //如果找到
                if (this.data[r][c] == 0) {
                    //用nextc位置的值代替c位置的值
                    this.data[r][c] = this.data[r][nextc];
                    //nextc位置的值改变成0
                    this.data[r][nextc] = 0;
                    c--; //c留在原地继续往后
                } else if (this.data[r][c] == this.data[r][nextc]) { //如果当前位置的值等于nextc位置的值
                    this.data[r][c] *= 2; //c的位置*2
                    this.score += this.data[r][c]; //更新分数
                    this.data[r][nextc] = 0; //nextc的位置改变成0
                }
            } else { //如果没有找到数字
                break; //退出循环
            }
        }
    },
    getNextinRow: function (r, c) {
        for (var i = c + 1; i < 4; i++) {
            //如果不为0，表示找到，就返回i，i对应的格子的几个位置
            if (this.data[r][i] != 0) {
                return i;
            }
        }
        return -1 //如果找不到，给出一个状态，用-1表示该方法的返回
    },
    moveRight: function () {
        var before = String(this.data); //移动前为数组拍照
        for (var r = 0; r < 4; r++) { //遍历data中每一行
            this.moveRightInRow(r); //右移第r行
        }
        var after = String(this.data); //移动后为数组拍照
        if (before != after) { //如果发生了移动
            this.randomNum(); //随机生成数
            if (this.isgameover()) { //如果游戏结束
                //就设置游戏状态为GAMEOVER
                this.status = this.gameover;
            }
            this.dataView(); //更新页面
        }
    },
    moveRightInRow: function (r) { //仅右移第r行
        //c从CN-1开始，到>0结束,反向遍历r行中每个格
        for (var c = 4; c > 0; c--) {
            //查找r行c位置前一个不为0的位置prevc
            var prevc = this.getPrevInRow(r, c);
            if (prevc != -1) { //如果找到
                console.log(c)
                if (this.data[r][c] == 0) { //如果c位置的值等于0
                    //用nextc位置的值代替c位置的值
                    this.data[r][c] = this.data[r][prevc];
                    //将nextc位置的值置为0
                    this.data[r][prevc] = 0;
                    c++; //c留在原地
                } else if ( //否则,如果c位置的值等于nextc位置值
                    this.data[r][c] == this.data[r][prevc]) {
                    this.data[r][c] *= 2; //c位置的值*2
                    this.score += this.data[r][c];
                    this.data[r][prevc] = 0; //nextc位置的值置为0
                }
            } else break; //否则，没找到，就退出循环
        }
    },
    getPrevInRow: function (r, c) { //查找r行c列左侧前一个不为0位置
        //i从c-1开始，到>=0结束, 反向遍历r行每个格
        for (var i = c - 1; i >= 0; i--) {
            //如果r行i列的值不是0,就返回i
            if (this.data[r][i] != 0) {
                return i;
            }
        } //(遍历结束)就返回-1
        return -1;
    },
    moveUp: function () { //上移所有行
        var before = String(this.data); //移动前为数组拍照
        for (var c = 0; c < 4; c++) { //遍历data中每一列
            this.moveUpInCol(c); //上移第c列
        }
        var after = String(this.data); //移动后为数组拍照
        if (before != after) { //如果发生了移动
            this.randomNum(); //随机生成数
            if (this.isgameover()) { //如果游戏结束
                //就设置游戏状态为GAMEOVER
                this.status = this.gameover;
            }
            this.dataView(); //更新页面
        }
    },
    moveUpInCol: function (c) { //仅上移第c列
        //r从0开始，到<RN-1结束,遍历c列中每一行
        for (var r = 0; r < 4; r++) {
            //查找c列r行下方下一个不为0的位置nextr
            var nextr = this.getNextInCol(r, c);
            if (nextr != -1) { //如果找到
                if (this.data[r][c] == 0) { //如果c位置的值等于0
                    //用nextr位置的值代替c位置的值
                    this.data[r][c] = this.data[nextr][c];
                    //将nextr位置的值置为0
                    this.data[nextr][c] = 0;
                    r--; //r留在原地
                } else if ( //否则,如果r位置值等于nextr位置值
                    this.data[r][c] == this.data[nextr][c]) {
                    this.data[r][c] *= 2; //r位置的值*2
                    this.score += this.data[r][c];
                    this.data[nextr][c] = 0; //nextr位置的值归0
                }
            } else {
                break; //否则，没找到，就退出循环
            }
        }
    },
    getNextInCol: function (r, c) { //查找c列r行下方下一个不为0位置
        //i从r+1开始，到<RN结束
        for (var i = r + 1; i < 4; i++) {
            //如果c列i行的值不是0,就返回i
            if (this.data[i][c] != 0) {
                return i;
            }
        } //(遍历结束)就返回-1
        return -1;
    },
    moveDown: function () { //下移所有行
        var before = String(this.data); //移动前为数组拍照
        for (var c = 0; c < 4; c++) { //遍历data中每一列
            this.moveDownInCol(c); //下移第c列
        }
        var after = String(this.data); //移动后为数组拍照
        if (before != after) { //如果发生了移动
            this.randomNum(); //随机生成数
            if (this.isgameover()) { //如果游戏结束
                //就设置游戏状态为GAMEOVER
                this.status = this.gameover;
            }
            this.dataView(); //更新页面
        }
    },
    moveDownInCol: function (c) { //仅上移第c列
        //r从RN-1开始，到>0结束,反向遍历c列中每一行
        for (var r = 3; r > 0; r--) {
            //查找c列r行上方前一个不为0的位置prevr
            var prevr = this.getPrevInCol(r, c);
            if (prevr != -1) { //如果找到
                if (this.data[r][c] == 0) { //如果c位置的值等于0
                    //用prevr位置的值代替c位置的值
                    this.data[r][c] = this.data[prevr][c];
                    //将prevr位置的值置为0
                    this.data[prevr][c] = 0;
                    r++; //r留在原地
                } else if ( //否则,如果r位置值等于prevr位置值
                    this.data[r][c] == this.data[prevr][c]) {
                    this.data[r][c] *= 2; //r位置的值*2
                    this.score += this.data[r][c];
                    this.data[prevr][c] = 0; //prevr位置的值归0
                }
            } else {
                break;
            } //否则，没找到，就退出循环

        }
    },
    getPrevInCol: function (r, c) { //查找c列r行下方下一个不为0位置
        //i从r-1开始，到>=0结束
        for (var i = r - 1; i >= 0; i--) {
            //如果c列i行的值不是0,就返回i
            if (this.data[i][c] != 0) {
                return i;
            }
        } //(遍历结束)就返回-1
        return -1;
    },


}
//window.onload = function(){
game.start();
//键盘被按下事件
document.onkeydown = function (event) {
    var event = event || arguments[0] || e;
    //		if(game.status==game.gamerunning){
    if (event.keyCode == 37) {
        game.moveLeft();
    } else if (event.keyCode == 39) {
        game.moveRight();
    } else if (event.keyCode == 38) {
        game.moveUp();
    } else if (event.keyCode == 40) {
        game.moveDown();
    }
    //		}
}
//}