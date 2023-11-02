print()
print('Количество вхождений заданного числа')
print()

n = int(input('Введите длину массива n: '))
arr = []
for i in range(n):
    num = int(input(f'Введите {i+1} элемент массива: '))
    arr.append(num)
x = int(input('Введите искомое число x: '))

#Решение дедовским методом  :)))
#count = 0
# for i in range(n):
#     if arr[i] == x:
#         count += 1
# if count > 0:
#     print(count)
# else:
#     print('Такого числа в массиве нет!')

if arr.count(x) > 0:
    print(f'массив: {arr}, заданное число: {x} - > количество вхождений х в массив: {arr.count(x)}')
else:
    print(f'Числа {x} в массиве нет!')


print() 
print('Самое близкое по значению число в массиве к заданному') 
print() 

list_1 = []
n = int(input('Введите длину массива: '))

for i in range(n):
    num = int(input(f'Введите {i+1} число массива: '))
    list_1.append(num)


value = int(input('Введите заданное число: '))
nearest_value = list_1[0]
for i in list_1:
    if abs(i - value)<abs(nearest_value - value):
        nearest_value = i
print(f'массив: {list_1}, заданное число: {value} -> ближайшее значение: {nearest_value}')


print()
print('Подсчет очков в игре')
print()

kir = {'А':1,'В':1,'Е': 1,'И': 1,'Н': 1,'О': 1,'Р': 1,'С': 1, 'Т': 1,'Д': 2,'К': 2, 'Л': 2, 'М': 2, 'П': 2, 'У': 2, 'Б': 3, 'Г': 3, 'Ё': 3, 'Ь': 3, 'Я': 3, 'Й': 4, 'Ы': 4, 'Ж': 5, 'З': 5, 'Х': 5, 'Ц': 5, 'Ч': 5, 'Ш': 8, 'Э': 8, 'Ю': 8, 'Ф': 10, 'Щ': 10, 'Ъ': 10, 'Э': 10 }
word = input('Введите слово на русском языке: ')
word = word.upper()
sum_ = 0
for i in range(len(word)):
    sum_ += kir[word[i]]
print(sum_)   
