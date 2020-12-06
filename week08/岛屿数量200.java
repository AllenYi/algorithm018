package com.arithmeticHomeWorkEight;

public class two_zero_zero {
    public int numIslands(char[][] grid) {
        int count= 0;
        for(int i= 0;i<grid.length;i++){ //遍历每一行
            for (int j =0;j<grid[0].length;j++){//遍历每一列
                if (grid[i][j] =='1'){//当有第一个陆地出现
                    dfs(grid,i,j); //深度遍历 寻找包括此点的岛屿边界。
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        //终结条件
        //(i, j) 越过矩阵边界;
        //grid[i][j] == 0，代表此分支已越过岛屿边界。
        if (i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0')return ;
        grid[i][j] ='0';//搜索岛屿的同时，执行 grid[i][j] = '0'，即将岛屿所有节点删除，以免之后重复搜索相同岛屿。
        //从 (i, j) 向此点的上下左右 (i+1,j),(i-1,j),(i,j+1),(i,j-1) 做深度搜索
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);

    }
}
