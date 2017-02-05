package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

/**
 * Created by Andy on 23.09.2016.
 */
public class Model  {

    //размер ячейки игрового поля
    public static final int FIELD_SELL_SIZE = 40;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
//    static Model mod = new Model();
    //private LevelLoader levelLoader = new LevelLoader(Paths.get("..\\res\\levels.txt"));
    private LevelLoader levelLoader = new LevelLoader(Paths.get("C:\\Users\\Andy\\Desktop\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt"));
    //getClass().getResource("/images/logo.png")

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        this.gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel = currentLevel + 1;
        restartLevel(currentLevel);
    }

    public void move(Direction direction){

        Player player = gameObjects.getPlayer();

        if (checkWallCollision(player, direction)) {
            return;
        }
        if (checkBoxCollision(direction)){
            return;
        }

        int sellSize = FIELD_SELL_SIZE;
        switch (direction) {
            case LEFT:
                player.move(-sellSize, 0);
                break;
            case RIGHT:
                player.move(sellSize, 0);
                break;
            case UP:
                player.move(0, -sellSize);
                break;
            case DOWN:
                player.move(0, sellSize);
        }
        checkCompletion();
    }


    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){

        for (Wall wall : gameObjects.getWalls()){

            if(gameObject.isCollision(wall, direction)){
                return true;
            }
        }
        return false;
    }


    public boolean checkBoxCollision(Direction direction){

        Player player = gameObjects.getPlayer();

        // найдем во что уперся игрок
        GameObject  stoped = null;
        for (GameObject gameObject: gameObjects.getAll()){
            if (!(gameObject instanceof Player)&&!(gameObject instanceof Home) && player.isCollision(gameObject, direction)){
                stoped = gameObject;
            }
        }
        //свободное место или дом
        if ((stoped == null)){
            return false;
        }
        if (stoped instanceof Box){
            Box stopedBox = (Box)stoped;
            if (checkWallCollision(stopedBox, direction)){
                return true;
            }
            for (Box box : gameObjects.getBoxes()){
                if(stopedBox.isCollision(box, direction)){
                    return true;
                }
            }
            switch (direction)
            {
                case LEFT:
                    stopedBox.move(-FIELD_SELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(FIELD_SELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -FIELD_SELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, FIELD_SELL_SIZE);
            }
        }
        return false;

    }

    public void checkCompletion() {

        boolean yes = true;

        for(Home home : gameObjects.getHomes()){
            boolean currentyes = false;

            for (Box box: gameObjects.getBoxes()){
                if ((box.getX() == home.getX()) && (box.getY() == home.getY()))
                    currentyes = true;
            }

            if (!currentyes)yes = false;
        }

        if (yes)
            eventListener.levelCompleted(currentLevel);
    }
}
/*
	Пришло время реализовать метод модели, отвечающий за движение move(), но для
начала реализуем вспомогательные методы. Добавь в класс модели методы:
15.1.	boolean checkWallCollision(CollisionObject gameObject, Direction direction). Этот
метод проверяет столкновение со стеной. Он должен вернуть true, если при движении
объекта gameObject в направлении direction произойдет столкновение со стеной,
иначе false. Для определения столкновения используй метод isCollision() у игрового
объекта.
15.2.	boolean checkBoxCollision(Direction direction). Этот метод проверяет
столкновение с ящиками. Метод должен:
15.2.1.	Вернуть true, если игрок не может быть сдвинут в направлении direction (там
находится: или ящик, за которым стена; или ящик за которым еще один ящик).
15.2.2.	Вернуть false, если игрок может быть сдвинут в направлении direction (там
находится: или свободная ячейка; или дом; или ящик, за которым свободная
ячейка или дом). При это, если на пути есть ящик, который может быть сдвинут, то
необходимо переместить этот ящик на новые координаты. Обрати внимание, что
все объекты перемещаются на фиксированное значение FIELD_SELL_SIZE, не
зависящее от размеров объекта, которые используются для его отрисовки.
Подсказка: для определения столкновений используй методы isCollision() игровых
объектов и метод checkWallCollision() модели.
15.3.	void checkCompletion(). Этот метод должен проверить пройден ли уровень (на
всех ли домах стоят ящики, их координаты должны совпадать). Если условие
выполнено, то проинформировать слушателя событий, что текущий уровень завершен.
15.4.	void move(Direction direction). Метод должен:
15.4.1.	Проверить столкновение со стеной (метод checkWallCollision()), если есть
столкновение – выйти из метода.
15.4.2.	Проверить столкновение с ящиками (метод checkBoxCollision()), если есть
столкновение – выйти из метода.
15.4.3.	Передвинуть игрока в направлении direction.
15.4.4.	Проверить завершен ли уровень.

Запусти программу и проверь, что игрока можно перемещать, он может перемещать
ящики, стены преграждают движение, а при перемещении всех ящиков в дома выводится
сообщение о прохождении уровня.***
	Начнем наполнять функционалом класс модели Model. Добавь в него:
11.1.	Поле GameObjects gameObjects. Оно будет хранить наши игровые объекты.
11.2.	Поле отвечающее за текущий уровень int currentLevel. Проинициализируй его
значением 1.
11.3.	 Поле отвечающие за загрузчик уровней LevelLoader levelLoader.
Проинициализируй его с помощью файла levels.txt из папки res.
11.4.	Метод GameObjects getGameObjects(), он должен возвращать все игровые
объекты.
11.5.	Метод restartLevel(int level), он должен получать новые игровые объекты для
указанного уровня у загрузчика уровня levelLoader и сохранять их в поле gameObjects.
11.6.	Метод restart(), он должен перезапускать текущий уровнь, вызывая restartLevel
с нужным параметром.
11.7.	Метод startNextLevel(), он должен увеличивать значение переменной
currentLevel, хранящей номер текущего уровня и выполнять перезапуск нового уровня.
9.5.	Добавь в классы Model, View и Field по методу setEventListener(EventListener
eventListener). Этот метод в классе View должен вызвать аналогичный метод у объекта
field, а в классах Model и Field устанавливать значение внутренних полей eventListener.
 */