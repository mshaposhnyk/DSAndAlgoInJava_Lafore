package com.company.chapter5;

public class MultiRowList {
    private MultiRowLink first;
    private int maxRows;
    private int maxColumns;
    private int actualRows;
    private int actualColumns;

    public MultiRowList(int rowCount, int columnCount){
        maxRows = rowCount;
        maxColumns = columnCount;
        actualColumns = 0;
        actualRows = 0;
    }

    public void insert(int row, int column,long data){
        /*if(actualColumns < column+1){
            if(first == null){
                first = new MultiRowLink(0);
            }
            createColumn(first,column);
            actualColumns = column+1;
            if(actualRows == 0) {
                actualRows = 1;
            }
        }*/
        if(actualRows < row+1){
            if(first == null){
                first = new MultiRowLink(0);
            }
            MultiRowLink currentRow = first;
            for(int i = 0; i<=row; i++){
                createColumn(currentRow,column);
                if(currentRow.above == null){
                    currentRow.above = new MultiRowLink(0);
                }
                currentRow = currentRow.above;
            }
            actualRows = row+1;
            if(actualColumns == 0){
                actualColumns = column+1;
            }
        }
        MultiRowLink currentRow = first;
        for (int i = 0; i<row; i++){
            currentRow = currentRow.above;
        }
        for(int i = 0; i<column;i++){
            currentRow = currentRow.left;
        }
        currentRow.value = data;
    }

    private void createColumn(MultiRowLink currentColumn,int column){
        for(int i = 0; i< column; i++){
            if(currentColumn.left == null){
                currentColumn.left = new MultiRowLink(0);
            }
            currentColumn = currentColumn.left;
        }
    }


    public long displayItem(int r, int c) {
        MultiRowLink currentRow = first;
        for (int i = 0; i<r; i++){
            currentRow = currentRow.above;
        }
        for(int i = 0; i<c;i++){
            currentRow = currentRow.left;
        }
        return currentRow.value;
    }
}
