public systemUi(){
         ~
         //불러오기
         table1.getColumnModel().getColumn(2).setCellRenderer(new CustomCellRenderer());
}


class CustomCellRenderer extends DefaultTableCellRenderer { 

    private JTextArea textArea; 
    private JScrollPane scrollPane; 

    public CustomCellRenderer() { 
        textArea = new JTextArea(); 
        scrollPane = new JScrollPane(textArea); 
    } 

    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) { 

        if(null != value) //셀 안에 내용이 있다면 텍스트 에리어 추가
            textArea.setText(value.toString()); 

        return scrollPane; //내용이 칸을 넘어간다면 스크롤 
    } 
}