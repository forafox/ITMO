#Конвертер без регулярки
import re #Библиотека для выражений
import io
import codecs
import time
#Главный класс
class Timetable: #Создаем класс
    def __init__(self, subjects): #Конструктор,что принимаем
        self.subjects = subjects #создаем характеристику класса, присваем ей полученное значение

class TimetableParser:
    def parser(self, line, subject):
        line = str(line).replace("  ", "") #создаем "единую" строку без пробелов
        line=line.replace('"',"")
        x = line.split(":") #разделяем ее по :
        key = x[0] #Ключ-свойство
        word = x[1].replace("\n", "") #убираем enter
        word = word.replace(' ', "",1)
        if key == "day":
            subject.day = word
        elif key == "time":
            st = x[1].replace("\n", "") + ":" + x[2].replace("\n", "") + ":" + x[3].replace("\n", "")
            subject.time =st.replace(' ', "",1)
        elif key == "room":
            subject.room = eval(word) #Получаем из строки число
        elif key == "lesson":
            subject.lesson = word
        elif key == "teacher":
            subject.teacher = word
        elif key == "location":
            subject.location = word
        elif key == "parity":
            subject.parity = word
        return subject
    def run(self, file):
        lines = file.readlines() #Список строк
        subjects = [Uroki(), Uroki(), Uroki(), Uroki(), Uroki(), Uroki()] #Массив экземпляров класса Uroki
        i = -1
        for line in lines:
            line = line.replace("\n", "")
            line = line.replace("  ", "")
            if  line.count("subject") == 1: #любой пробельный(ноль или более) и любая цифра
                i += 1                                           #Проверяем является ли строка заголовком
            elif line.count("timetable") != 1:                   #Проверяем является ли она "главной"
                subjects[i] = self.parser(line, subjects[i])     #У самого себя вызываем метод parser, отдаем текущую строку и элемент массива
        schedule = Timetable(subjects) #Создаем экзепляр класса. Передаем массив полученных значений
        return schedule

#Создаем класс и наделяем его свойствами
class Uroki:
    def __init__(self):
        self.day = None
        self.time = None
        self.room = None
        self.lesson = None
        self.teacher = None
        self.location = None
        self.parity = None

#Основной запуск программы

def start(number):
    for kol in range(0,number):
        file = open("1.yml", "r", encoding="utf-8") #Открываем файл только для чтения
        parser = TimetableParser() #Создаем экзепляр класса#
        schedule = parser.run(file) #Вызываем метод у экземляра

        xml = "<timetable>\n" #Начало итогового файла
        for i in range(len(schedule.subjects)): #Пробегаемся по объкектам класса uroki
            xml += "\t<subject{}>\n".format(i+1)
            sub_dict = schedule.subjects[i].__dict__  #Атрибуты класса
            for p in sub_dict:
                xml += "\t\t<{}>{}</{}>\n".format(p, sub_dict[p], p)
            xml += "\t</subject{}>\n".format(i+1)
        xml += "</timetable>"  #Конец итогового файла
        f = codecs.open("Myresult.xml", "w", "utf-8")
        f.write(xml)
def startWML(number):
    for kol in range(0,number):
        file = open("1.yml", "r", encoding="utf-8") #Открываем файл только для чтения
        parser = TimetableParser() #Создаем экзепляр класса#
        schedule = parser.run(file) #Вызываем метод у экземляра

        xml = "<wml>\n" #Начало итогового файла
        xml += "\t<card>\n"  # Начало итогового файла
        for i in range(len(schedule.subjects)): #Пробегаемся по объкектам класса uroki
            xml += "\t\t<subject{}>\n".format(i+1)
            sub_dict = schedule.subjects[i].__dict__  #Атрибуты класса
            for p in sub_dict:
                xml += "\t\t\t<{}>{}</{}>\n".format(p, sub_dict[p], p)
            xml += "\t\t</subject{}>\n".format(i+1)
        xml += "\t</card>\n"  #Конец итогового файла
        xml += "</wml>\n"  # Конец итогового файла
        f = codecs.open("MyresultWML.wml", "w", "utf-8")
        f.write(xml)

def startCSV(number):
    for kol in range(0,number):
        file = open("1.yml", "r", encoding="utf-8") #Открываем файл только для чтения
        parser = TimetableParser() #Создаем экзепляр класса#
        schedule = parser.run(file) #Вызываем метод у экземляра
        xml="day,time,room,lesson,teacher,location,parity\n"
        for i in range(len(schedule.subjects)): #Пробегаемся по объкектам класса uroki
            sub_dict = schedule.subjects[i].__dict__  #Атрибуты класса
            for p in sub_dict:
                if(str(sub_dict[p]).find(",")>0):
                    xml += "\"{}\",".format(sub_dict[p])
                else:
                    xml += "{},".format(sub_dict[p])
            xml=xml[:-1]
            xml+="\n"
        f = codecs.open("MyresultCSV.csv", "w", "utf-8")
        f.write(xml)
start1 = time.time()
startWML(1)
print('Десятикратное время работы моего парсера:' + str(time.time() - start1))
