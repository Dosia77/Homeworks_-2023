from file_operation import begin, add, edit,delete,read,select,sort

def start():
    print("ВАЖНО!!! Если записная книжка не создана, необходимо начать работу с команды № 1!")
    while True:

        print("Меню:\n1 - Создать первую заметку\n2 - Добавить новую заметку\n3 - Просмотреть все заметки\n4 - Редактировать заметку\n5 - Удалить заметку\n6 - Поиск заметки по параметрам\n0 - Выход")
   
        choice = input("Выберите действие: ")

        if choice == "1":
            options = input("Вы уверены, что хотите удалить все записи и начать сначала?\nВвудите 'да' или 'нет': ")
            if options == "да":
                print("Тогда начнем!:)))")
                begin.create_first_note()
            if options == "нет":
                break       
            else:
                print("Ваш ответ непонятен!")
            
        elif choice == "2":
            add.add_notes()

        elif choice == "3":
            read.read_notes()

        elif choice == "4":
            edit.edit_note()

        elif choice == "5":
            delete.delete_note()

        elif choice == "6":
            select.select_to_parametr()

        elif choice == "0":
            break

        else:
            print("Некорректный выбор. Попробуйте снова.")