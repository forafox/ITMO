#Конвертер с регуляркой

import re #Библиотека для выражений
import time
#Главный класс
class Timetable: #Создаем класс
    def __init__(self, subjects): #Конструктор,что принимаем
        self.subjects = subjects #создаем характеристику класса, присваем ей полученное значение

class TimetableParser:
    def parser(self, line, subject):
        line = str(line).replace("  ", "") #создаем "единую" строку без пробелов
        x = line.split(":") #разделяем ее по :
        key = x[0] #Ключ-свойство
        word = x[1].replace("\n", "") #убираем enter
        if key == "day":
            subject.day = word
        elif key == "time":
            subject.time = x[1].replace("\n", "") + ":" + x[2].replace("\n", "") + ":" + x[3].replace("\n", "")
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
            if re.fullmatch(r"\s*subject\d:", line) is not None: #любой пробельный(ноль или более) и любая цифра
                i += 1                                           #Проверяем является ли строка заголовком
            elif line.count("timetable") != 1:                   #Проверяем является ли она "главной"
                subjects[i] = self.parser(line, subjects[i])     #У самого себя вызываем метод parser, отдаем текущую строку и элемент массива
        schedule = Timetable(subjects) #Создаем экзепляр класса. Передаем массив полученных значений
        return schedule

#Создаем класс и наделяем его свойствами
class Uroki:
    def __init__(self):
        self.day = 1
        self.time = 1
        self.room = 1
        self.lesson = 1
        self.teacher = 1
        self.location = 1
        self.parity = 1

#Основной запуск программы
def start():
    file = open("../1.yml", "r", encoding="utf-8") #Открываем файл только для чтения
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
    # print(xml)
# start()

start1 = time.time()
for i in range(10):
    start()
print('Десятикратное время работы моего парсера:' + str(time.time() - start1))
