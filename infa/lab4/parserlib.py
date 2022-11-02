#Конвертер через библиотеку
import xmlplain
import time
start1 = time.time()
for i in range(10):
  # Read the YAML file
  with open("1.yml") as inf:
    root = xmlplain.obj_from_yaml(inf)

  # Output back XML
  with open("result.xml", "w") as outf:
    xmlplain.xml_from_obj(root, outf, pretty=True)

#################
print('Десятикратное время работы моего парсера:' + str(time.time() - start1))