public systemUi(){
         ~
         //�ҷ�����
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

        if(null != value) //�� �ȿ� ������ �ִٸ� �ؽ�Ʈ ������ �߰�
            textArea.setText(value.toString()); 

        return scrollPane; //������ ĭ�� �Ѿ�ٸ� ��ũ�� 
    } 
}