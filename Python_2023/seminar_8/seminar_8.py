def choose(phonebook):
    while True:
        print('Что вы хотите сделать?')
        choice = input('1 - Импортировать данные\n2 - Найти контакт\n3 - Добавить контакт\n\
4 - Изменить контакт\n5 - Удалить контакт\n6 - Просмотреть все контакты\n7 - Копировать по номеру строки\n0 - Выйти\n')
        print()
        if choice == '1':
            file_add = input('Введите название импортируемого файла с расширением: ')
            import_file(file_add, phonebook)
        elif choice == '2':
            contacts = read_file(phonebook)
            find_number(contacts)
        elif choice == '3':
            add_phone(phonebook)
        elif choice == '4':
            change_phone(phonebook)
        elif choice == '5':
            delete(phonebook)
        elif choice == '6':
            show(phonebook)
        elif choice == '7':
            get_nth_line()   
        elif choice == '0':
            break
        else:
            print('Неправильно выбрана команда!')
            print()
            continue


def import_file(file_add, phonebook):
    try:
        with open(file_add, 'r', encoding='utf-8') as new_contacts, open(phonebook, 'a', encoding='utf-8') as file:
            contacts_to_add = new_contacts.readlines()
            file.writelines(contacts_to_add)
    except FileNotFoundError:
        print(f'{file_add} не найден')


def read_file(file_name):
    with open(file_name, 'r', encoding='utf-8') as file:
        lines = file.readlines()
    headers = ['Фамилия', 'Имя', 'Номер телефона']
    contacts = []
    for line in lines:
        line = line.strip().split()
        contacts.append(dict(zip(headers, line)))
    return contacts


def read_file2(file_name):
    with open(file_name, 'r', encoding='utf-8') as file:
        contacts = []
        for line in file.readlines():
            contacts.append(line.split())
    return contacts


def search_parameters():
    print('Где искать?')
    search_field = input('1 - по фамилии\n2 - по имени\n3 - по номеру телефона\n')
    print()
    search_value = None
    if search_field == '1':
        search_value = input('Введите фамилию: ')
        print()
    elif search_field == '2':
        search_value = input('Введите имя: ')
        print()
    elif search_field == '3':
        search_value = input('Введите номер: ')
        print()
    return search_field, search_value


def find_number(contacts):
    search_field, search_value = search_parameters()
    search_value_dict = {'1': 'Фамилия', '2': 'Имя', '3': 'Номер телефона'}
    found_contacts = []
    for contact in contacts:
        if contact[search_value_dict[search_field]] == search_value:
            found_contacts.append(contact)
    if len(found_contacts) == 0:
        print('Нет такого абонента!')
    else:
        print_all(found_contacts)
    print()


def new_phone():
    last_name = input('Введите фамилию: ')
    first_name = input('Введите имя: ')
    phone_number = input('Введите номер телефона: ')
    return last_name, first_name, phone_number


def add_phone(file_name):
    info = ' '.join(new_phone())
    with open(file_name, 'a', encoding='utf-8') as file:
        file.write(f'{info}\n')


def show(file_name):
    list_of_contacts = sorted(read_file(file_name), key=lambda x: x['Фамилия'])
    print_all(list_of_contacts)
    print()
    return list_of_contacts


def search_to_fields(contacts: list):
    field, value = search_parameters()
    result = []
    for contact in contacts:
        if contact[int(field) - 1] == value:
            result.append(contact)
    if len(result) == 1:
        return result[0]
    elif len(result) > 1:
        print('Найдено несколько контактов')
        for i in range(len(result)):
            print(f'{i + 1} - {result[i]}')
        number = int(input('Выберите номер абонента, который вы хотите изменить: '))
        return result[number - 1]
    else:
        print('Контакт не обнаружен!')
    print()


def change_phone(file_name):
    contacts = read_file2(file_name)
    change_number= search_to_fields(contacts)
    contacts.remove(change_number)
    print('Что вы хотите изменить?')
    field = input('1 - Фамилия\n2 - Имя\n3 - Номер телефона\n')
    if field == '1':
        change_number[0] = input('Введите фамилию: ')
    elif field == '2':
        change_number[1] = input('Введите имя: ')
    elif field == '3':
       change_number [2] = input('Введите номер телефона: ')
    contacts.append(change_number)
    with open(file_name, 'w', encoding='utf-8') as file:
        for contact in contacts:
            line = ' '.join(contact) + '\n'
            file.write(line)


def delete(file_name):
    contacts = read_file2(file_name)
    change_number = search_to_fields(contacts)
    contacts.remove(change_number)
    with open(file_name, 'w', encoding='utf-8') as file:
        for contact in contacts:
            line = ' '.join(contact) + '\n'
            file.write(line)


def print_all(contacts: list):
    for contact in contacts:
        for key, value in contact.items():
            print(f'{key}: {value:12}', end='')
        print()

def get_nth_line(): 
    number = int(input('Введите номер строки для копирования: '))
    with open('Phonebook.txt') as source, open('output.txt', 'a', encoding='utf-8') as destination:
        try:
            lines = source.readlines()
            destination.write(lines[number-1]+'\n')
            print('Строка успешно скопирована')
        except Exception:
            print('Нет такой строки!')

if __name__ == '__main__':
    file = 'Phonebook.txt'
    choose(file)

    # добавлено