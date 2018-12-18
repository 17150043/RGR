package Program;

//Добавляем библиотеки для работы с текстовыми полями, метками,
//для создания графического окна
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


//Главный класс, реализуюй интерфейс ActionListener
//Интерфейс нужен для обработки события нажатия на кнопку
public class SalaryCalcMain implements ActionListener{

  JFrame frame = new JFrame("Зарплатный калькулятор"); //главное окно
  JPanel panelLeft = new JPanel(); //панель с метками
  JPanel panelRight = new JPanel(); //панель с текстовыми полями
  JPanel panelBottom = new JPanel(); //панель с кнопками
  public JTextField[] arrTf = new JTextField[8];//массив текстовых полей
 
   //конструктор
  public SalaryCalcMain(){
     
      //устанавливаем менеджер компоновки для панели с метками
      //делаем выравнивание по вертикали
      panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
      //устанавлиаем  размер 250 на 300 пикселей
      panelLeft.setPreferredSize(new Dimension(250, 300));
      //устанавливаем менеджер компоновки для панели с текстовыми полями
      //делаем выравнивание по вертикали
      panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
      //устанавливаем  размер 200 на 300 пикселей
      panelRight.setPreferredSize(new Dimension(200,300));
     
      //добавлям метки через метод addLabel
      addLabel(panelLeft, "Тарифная ставка (в час):", Color.BLACK);
      addLabel(panelLeft, "Рабочий день (часы):", Color.BLACK);
      addLabel(panelLeft, "Количество отработанных дней:", Color.BLACK);
      addLabel(panelLeft, "Налоговая ставка (%)*:", Color.BLACK);
      addLabel(panelLeft, "Чистый заработок(без налогов):", Color.BLACK);
      addLabel(panelLeft, "Премия***:", Color.BLACK);
      addLabel(panelLeft, "Подоходный налог:", Color.BLACK);
      addLabel(panelLeft, "Сумма к выдаче:", Color.BLACK);
     
      //добавляем текстовые поля через цикл и записываем их в массив
      for(int i=0; i<arrTf.length; i++){
          //записываем ссылку из метода в массив для дальнейшей работы с
          //тестовым поелм
          arrTf[i] = addTextField(panelRight);
      }
      
      arrTf[4].setEditable(false);
      arrTf[5].setEditable(false);
      arrTf[6].setEditable(false);
      arrTf[7].setEditable(false);
     
      //добавляем кнопки расчета и сброса
      JButton calc = addButton(panelBottom, "Расчет");
      //добавляем слушатель на событие нажатия
      calc.addActionListener(this);
      JButton reset = addButton(panelBottom, "Сброс");
      //добавляем слушатель на событие нажатия
      reset.addActionListener(this);
      //делаем главную форму видимой
      frame.setVisible(true);
      //устанавливаем действие при нажатии на крестик - завершение приложения
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //устанавливаем начальное положение относительно центра экрана (по центру)
      frame.setLocationRelativeTo(null);
      //Устанавливаем размер главного окна(550 на 350)
      frame.setSize(550,350);
      //Добавляем метку с информацией к работе в самый верх окна
      JLabel top = new JLabel("Для расчета заработной платы, заполните все поля:");
      //изменение шрифта 
      top.setFont(new Font("Arial", Font.BOLD, 20));
      //устанавливаем выравнивание текста в метке по центру
      top.setHorizontalAlignment(JLabel.CENTER);
     
      //добавляем панели на клавное окно
      frame.add(top, BorderLayout.NORTH);
      frame.add(panelLeft, BorderLayout.WEST);
      frame.add(panelRight, BorderLayout.EAST);
      frame.add(panelBottom, BorderLayout.SOUTH);
      frame.setResizable(false); //запрещаем изменение размеров главного окна
         }
     
  //метод добавления текстовых меток
  public void addLabel(JComponent container, String name, Color color){
      //создаем тестовую метку с именем name
      JLabel lb = new JLabel(name);
      //устанавливаем максимально допустимый размер
      lb.setMaximumSize(new Dimension(500,30));
      lb.setFont(new Font("Arial", Font.PLAIN, 15));
      //устанавливаем цвета текста
      lb.setForeground(color);
      //устанавливаем выравнивание по правому краю
      lb.setHorizontalAlignment(JLabel.RIGHT);
   
      //Добавляем текстовую метку в панель
      container.add(lb);
  }
 
  //метод добавления текстовых полей
  public JTextField addTextField(JComponent container){
      //Создаем текстовое поле
      JTextField tf = new JTextField();
      //устанавливаем его максимально допустимый размер
      tf.setMaximumSize(new Dimension(150,30));
 

      //добавляем текстовое поле на панель
      container.add(tf);
      //возвращаем ссылку на текстовое поле
      return tf;
  }
 
  //метод добавления кнопок
  public JButton addButton(JComponent container, String name){
      //Создаем кнопку
      JButton btn = new JButton(name);
      //Устанавливаем максимально допустимый размер
      btn.setMaximumSize(new Dimension(150,40));
      //Выравниваем по горизонтали по центру
      btn.setHorizontalAlignment(JButton.CENTER);
      //добавляем кнопку на панель
      container.add(btn);
      //возвращаем ссылку на кнопку
      return btn;
  }

 // Метод расчета чистого заработка (без налога)
  public Double calcPribil (double stavka, double hours, double days){
	  double pribil = stavka * hours * days; //Расчет чистой прибыли
	  return (pribil);
  }
  
//Метод расчета премии
 public Double calcPremia (double pribil) {
	  double premia = pribil * 0.1; //Расчет премии
	  return (premia);
 }
 
//Метод расчета налога
public Double calcNalog (double pribil, double premia, double stavkaNalog) {
	  double nalog = (pribil + premia) * stavkaNalog / 100; //Расчет налога
	  return (nalog);
}


//Метод расчета ЗП
public Double calcSalary(double pribil, double premia, double nalog) {
	  double salary = pribil + premia - nalog; //Расчет ЗП
	  return (salary);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new SalaryCalcMain();
        }
    });
}

  //Метод обработки события нажатия на кнопку
  @Override
  public void actionPerformed(ActionEvent e) {
      //узнаем имя кнопки, на которую нажали
      if (e.getActionCommand().equals("Расчет")) {
          try {
        	  //Получаем значения из полей
        	  double stavka = Double.valueOf(arrTf[0].getText()); //Получаем значения из поля Ставка и преобразовываем в тип Double
              double hours = Double.valueOf(arrTf[1].getText());  //Получаем значения из поля Часы и преобразовываем в тип Double
              double days = Double.valueOf(arrTf[2].getText());  //Получаем значения из поля Дни работы и преобразовываем в тип Double
              double stavkaNalog = Double.valueOf(arrTf[3].getText());  //Получаем значения из поля Налоговая ставка и преобразовываем в тип Double
              
        	  double pribil = calcPribil(stavka, hours, days); // Вызов функции расчета чистой прибыли
        	  System.out.println("Прибыль:" + pribil); //Вывод в консоль значения
        	  arrTf[4].setText(String.format("%.2f", pribil)); //Добавление значения прибыли во фрейм
        	  
        	  double premia = calcPremia(pribil);// Вызов функции расчета премии
        	  System.out.println("Премия:" + premia); //Вывод в консоль значения
        	  arrTf[5].setText(String.format("%.2f", premia)); //Добавление значения прибыли во фрейм
        	  
        	  double nalog = calcNalog(pribil, premia, stavkaNalog);
        	  System.out.println("Налог:" + nalog); //Вывод в консоль значения
        	  arrTf[6].setText(String.format("%.2f", nalog)); //Добавление значения прибыли во фрейм
        	  
        	  double salary = calcSalary(pribil, premia, nalog);
        	  System.out.println("ЗП:" + salary); //Вывод в консоль значения
        	  arrTf[7].setText(String.format("%.2f", salary)); //выводим зп на руки в 8-е т.п.
        	  
        	  
          } catch (Exception ex) {
              JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
          }
         
      }else{
          //очищаем все поля
          for(int i=0; i<arrTf.length; i++){
              arrTf[i].setText("");
          }
      }
  }
}
