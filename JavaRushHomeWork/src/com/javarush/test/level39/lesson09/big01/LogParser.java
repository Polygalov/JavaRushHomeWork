package com.javarush.test.level39.lesson09.big01;

import com.javarush.test.level39.lesson09.big01.query.*;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery
{
    private Path logDir;
    private List<String> linesList;

    public LogParser(Path logDir)
    {
        this.logDir = logDir;
        linesList = getLinesList();
    }
    private List<String> getLinesList()
    {
        String[] files = logDir.toFile().list(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return name.endsWith(".log");
            }
        });

        List<String> lines = new ArrayList<>();
        for (String file : files)
        {
            try
            {
                lines.addAll(Files.readAllLines(Paths.get(logDir + File.separator + file), Charset.defaultCharset()));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return lines;
    }

    private void addStringEntity(Date after, Date before, Set<String> enteties, String[] parts, int part)
    {
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before))
        {
            enteties.add(parts[part]);
        }
    }
    private void addDateEntity(Date after, Date before, Set<Date> enteties, String[] parts)
    {
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before))
        {
            enteties.add(getDate(parts[2]));
        }
    }
    private void addEventEntity(Date after, Date before, Set<Event> enteties, String[] parts)
    {
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before))
        {
            enteties.add(Event.valueOf(parts[3].split(" ")[0]));
        }
    }

    private boolean isCompatibleDate(long lineDateTime, Date after, Date before)
    {
        if (after == null && before == null)
        {
            return true;
        } else if (after == null)
        {
            if (lineDateTime <= before.getTime())
            {
                return true;
            }
        } else if (before == null)
        {
            if (lineDateTime >= after.getTime())
            {
                return true;
            }
        } else
        {
            if (lineDateTime >= after.getTime() && lineDateTime <= before.getTime())
            {
                return true;
            }
        }
        return false;
    }
    private Date getDate(String part)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date date = null;
        try
        {
            date = dateFormat.parse(part);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }


    @Override
    public int getNumberOfUniqueIPs(Date after, Date before)
    {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before)
    {
        Set<String> uniqueIPs = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            addStringEntity(after, before, uniqueIPs, parts, 0);
        }
        return uniqueIPs;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before)
    {
        Set<String> iPsForUser = new HashSet<>();
        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1]))
                addStringEntity(after, before, iPsForUser, parts, 0);
        }

        return iPsForUser;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before)
    {
        Set<String> iPsForEvent = new HashSet<>();
        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (event.toString().equals(parts[3].split(" ")[0]))
                addStringEntity(after, before, iPsForEvent, parts, 0);
        }

        return iPsForEvent;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before)
    {
        Set<String> iPsForStatus = new HashSet<>();
        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (status.toString().equals(parts[4]))
                addStringEntity(after, before, iPsForStatus, parts, 0);
        }

        return iPsForStatus;
    }

    @Override
    public Set<String> getAllUsers()
    {
        Set<String> allUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            addStringEntity(null, null, allUsers, parts, 1);
        }
        return allUsers;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before)
    {
        Set<String> allUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            addStringEntity(after, before, allUsers, parts, 1);
        }
        return allUsers.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before)
    {
        Set<String> numberOfUserEvents = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1]))
            addStringEntity(after, before, numberOfUserEvents, parts, 3);
        }
        return numberOfUserEvents.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before)
    {
        Set<String> usersForIP = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (ip.equals(parts[0]))
                addStringEntity(after, before, usersForIP, parts, 1);
        }
        return usersForIP;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before)
    {
        Set<String> loggedUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Event.LOGIN.toString().equals(parts[3]))
                addStringEntity(after, before, loggedUsers, parts, 1);
        }
        return loggedUsers;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before)
    {
        Set<String> downloadedPluginUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Event.DOWNLOAD_PLUGIN.toString().equals(parts[3]))
                addStringEntity(after, before, downloadedPluginUsers, parts, 1);
        }
        return downloadedPluginUsers;
    }


    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before)
    {
        Set<String> wroteMessageUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Event.WRITE_MESSAGE.toString().equals(parts[3]))
                addStringEntity(after, before, wroteMessageUsers, parts, 1);
        }
        return wroteMessageUsers;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before)
    {
        Set<String> downloadedPluginUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if ( Event.SOLVE_TASK.toString().equals(parts[3].split(" ")[0]))
                addStringEntity(after, before, downloadedPluginUsers, parts, 1);
        }
        return downloadedPluginUsers;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task)
    {
        Set<String> solvedTaskUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if ( Event.SOLVE_TASK.toString().equals(parts[3].split(" ")[0])
                    && task == Integer.valueOf(parts[3].split(" ")[1]))
                addStringEntity(after, before, solvedTaskUsers, parts, 1);
        }
        return solvedTaskUsers;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before)
    {
        Set<String> doneTaskUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if ( Event.DONE_TASK.toString().equals(parts[3].split(" ")[0]))
                addStringEntity(after, before, doneTaskUsers, parts, 1);
        }
        return doneTaskUsers;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task)
    {
        Set<String> doneTaskUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (  Event.DONE_TASK.toString().equals(parts[3].split(" ")[0])
                    && task == Integer.valueOf(parts[3].split(" ")[1]))
                addStringEntity(after, before, doneTaskUsers, parts, 1);
        }
        return doneTaskUsers;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before)
    {
        Set<Date> datesForUserAndEvent = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1])&& event.toString().equals(parts[3].split(" ")[0]))
                addDateEntity(after, before, datesForUserAndEvent, parts);
        }
        return datesForUserAndEvent;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before)
    {
        Set<Date> datesWhenSomethingFailed = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if  (Status.FAILED.toString().equals(parts[4]))
                addDateEntity(after, before, datesWhenSomethingFailed, parts);
        }
        return datesWhenSomethingFailed;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before)
    {
        Set<Date> datesWhenErrorHappened = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if  (Status.ERROR.toString().equals(parts[4]))
                addDateEntity(after, before, datesWhenErrorHappened, parts);
        }
        return datesWhenErrorHappened;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before)
    {

        Date curentDate = new Date(Long.MAX_VALUE);
        boolean isDateChanged = false;
        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
        if (user.equals(parts[1])&& Event.LOGIN.toString().equals(parts[3]))
            if  (curentDate.getTime() >getDate(parts[2]).getTime())
                curentDate = getDate(parts[2]);
            isDateChanged = true;
        }
        return isDateChanged ? curentDate : null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before)
    {
        Date curentDate = new Date(Long.MAX_VALUE);
        boolean isDateChanged = false;
        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1])&& Event.SOLVE_TASK.toString().equals(parts[3].split(" ")[0])&& task == Integer.valueOf(parts[3].split(" ")[1]))
                if  (curentDate.getTime() >getDate(parts[2]).getTime())
                    curentDate = getDate(parts[2]);
            isDateChanged = true;
        }
        return isDateChanged ? curentDate : null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before)
    {

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1])&& Event.DONE_TASK.toString().equals(parts[3].split(" ")[0])&& task == Integer.valueOf(parts[3].split(" ")[1]))

            {
                return getDate(parts[2]);
            }
        }
        return null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before)
    {
        Set<Date> datesWhenUserWroteMessage = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if  (user.equals(parts[1])&&Event.WRITE_MESSAGE.toString().equals(parts[3]))
                addDateEntity(after, before, datesWhenUserWroteMessage, parts);
        }
        return datesWhenUserWroteMessage;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before)
    {
        Set<Date> datesWhenUserDownloadedPlugin = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if  (user.equals(parts[1])&&Event.DOWNLOAD_PLUGIN.toString().equals(parts[3]))
                addDateEntity(after, before, datesWhenUserDownloadedPlugin, parts);
        }
        return datesWhenUserDownloadedPlugin;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before)
    {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before)
    {
        Set<Event> allEvents = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            addEventEntity(after, before, allEvents, parts);
        }
        return allEvents;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before)
    {
        Set<Event> eventsForIP = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if  (ip.equals(parts[0]))
            addEventEntity(after, before, eventsForIP, parts);
        }
        return eventsForIP;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before)
    {
        Set<Event> eventsForUser = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if  (user.equals(parts[1]))
                addEventEntity(after, before, eventsForUser, parts);
        }
        return eventsForUser;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before)
    {
        Set<Event> failedEvents = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if  (Status.FAILED.toString().equals(parts[4]))
                addEventEntity(after, before, failedEvents, parts);
        }
        return failedEvents;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before)
    {
        Set<Event> errorEvents = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if  (Status.ERROR.toString().equals(parts[4]))
                addEventEntity(after, before, errorEvents, parts);
        }
        return errorEvents;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before)
    {
        int numberOfAttemptToSolveTask=0;

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if  (Event.SOLVE_TASK.toString().equals(parts[3].split(" ")[0])&& task == Integer.valueOf(parts[3].split(" ")[1]))
                numberOfAttemptToSolveTask++;
        }
        return numberOfAttemptToSolveTask;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before)
    {
        int numberOfSuccessfulAttemptToSolveTask=0;

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if  (Event.DONE_TASK.toString().equals(parts[3].split(" ")[0])&& task == Integer.valueOf(parts[3].split(" ")[1])&& Status.OK.toString().equals(parts[4]))
                numberOfSuccessfulAttemptToSolveTask++;
        }
        return numberOfSuccessfulAttemptToSolveTask;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before)
    {
        return getTasksMap(Event.SOLVE_TASK);
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before)
    {
        return getTasksMap(Event.DONE_TASK);
    }
    public Map<Integer, Integer> getTasksMap(Event event){
        Map<Integer, Integer> allTasksAndTheirNumber = new HashMap<>();
        int numberOfSolvedTask;
        int value;
        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if  (event.toString().equals(parts[3].split(" ")[0])){
                numberOfSolvedTask = Integer.valueOf(parts[3].split(" ")[1]);
                if (allTasksAndTheirNumber.containsKey(numberOfSolvedTask))
                {
                    value = allTasksAndTheirNumber.get(numberOfSolvedTask) + 1;
                    allTasksAndTheirNumber.put(numberOfSolvedTask, value);
                } else
                {
                    allTasksAndTheirNumber.put(numberOfSolvedTask, 1);
                }
            }
        }



        return allTasksAndTheirNumber;
    }

    @Override
    public Set<Object> execute(String query)
    {
        String field1 = "";
        String field2 = "";
        String value1 = "";
        String value2 = "";
        String value3 = "";

        List<String> values = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"[\\w \\.:]+\"");
        Matcher matcher = pattern.matcher(query);
        while (matcher.find())
        {
            values.add(matcher.group().replace("\"", ""));
        }

        if (query.split(" ").length > 2)
        {
            field1 = query.split(" ")[1];
            field2 = query.split(" ")[3];
            value1 = values.get(0);
            if (values.size() > 1)
            {
                value2 = values.get(1);
                value3 = values.get(2);
            }
        }
        Set<Object> querySet = new HashSet<>();
        for (String line : linesList)
        {
            String[] lineParts = line.split("\\t");
            if (values.size() == 0)
            {
                if (query.equals("get ip"))
                    querySet.add(lineParts[0]);
                if (query.equals("get user"))
                    querySet.add(lineParts[1]);
                if (query.equals("get date"))
                {
                    Date date = getDate(lineParts[2]);
                    querySet.add(date);
                }

                if (query.equals("get event")){
                    Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                    querySet.add(event);
                }

                if (query.equals("get status"))
                {
                    Status status = Status.valueOf(lineParts[4]);
                    querySet.add(status);
                }

            }

        else
        {
            switch (field1)
            {
                case "ip":
                    switch (field2)
                    {
                        case "ip":
                        case "user":
                        case "date":
                        case "status":
                            if (value1.equals(lineParts[getField2Index(field2)]))
                            {
                                if (values.size() == 3)
                                {
                                    Date date = getDate(lineParts[2]);
                                    if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                    {
                                        querySet.add(lineParts[0]);
                                    }
                                } else
                                {
                                    querySet.add(lineParts[0]);
                                }
                            }
                            break;
                        case "event":
                            if (value1.equals(lineParts[3].split(" ")[0]))
                            {
                                if (values.size() == 3)
                                {
                                    Date date = getDate(lineParts[2]);
                                    if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                    {
                                        querySet.add(lineParts[0]);
                                    }
                                } else
                                {
                                    querySet.add(lineParts[0]);
                                }
                            }
                            break;
                    }
                    break;
                case "user":
                    switch (field2)
                    {
                        case "ip":
                        case "user":
                        case "date":
                        case "status":
                            if (value1.equals(lineParts[getField2Index(field2)]))
                            {
                                if (values.size() == 3)
                                {
                                    Date date = getDate(lineParts[2]);
                                    if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                    {
                                        querySet.add(lineParts[1]);
                                    }
                                } else
                                {
                                    querySet.add(lineParts[1]);
                                }
                            }
                            break;
                        case "event":
                            if (value1.equals(lineParts[3].split(" ")[0]))
                            {
                                if (values.size() == 3)
                                {
                                    Date date = getDate(lineParts[2]);
                                    if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                    {
                                        querySet.add(lineParts[1]);
                                    }
                                } else
                                {
                                    querySet.add(lineParts[1]);
                                }
                            }
                            break;
                    }
                    break;
                case "date":
                    switch (field2)
                    {
                        case "ip":
                        case "user":
                        case "date":
                        case "status":
                            if (value1.equals(lineParts[getField2Index(field2)]))
                            {
                                if (values.size() == 3)
                                {
                                    Date date = getDate(lineParts[2]);
                                    if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                    {
                                        date = getDate(lineParts[2]);
                                        querySet.add(date);
                                    }
                                } else
                                {
                                    Date date = getDate(lineParts[2]);
                                    querySet.add(date);
                                }
                            }
                            break;
                        case "event":
                            if (value1.equals(lineParts[3].split(" ")[0]))
                            {
                                if (values.size() == 3)
                                {
                                    Date date = getDate(lineParts[2]);
                                    if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                    {
                                        date = getDate(lineParts[2]);
                                        querySet.add(date);
                                    }
                                } else
                                {
                                    Date date = getDate(lineParts[2]);
                                    querySet.add(date);
                                }
                            }
                            break;
                    }
                    break;
                case "event":
                    switch (field2)
                    {
                        case "ip":
                        case "user":
                        case "date":
                        case "status":
                            if (value1.equals(lineParts[getField2Index(field2)]))
                            {
                                if (values.size() == 3)
                                {
                                    Date date = getDate(lineParts[2]);
                                    if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                    {
                                        Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                                        querySet.add(event);
                                    }
                                } else
                                {
                                    Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                                    querySet.add(event);
                                }
                            }
                            break;
                        case "event":
                            if (value1.equals(lineParts[3].split(" ")[0]))
                            {
                                if (values.size() == 3)
                                {
                                    Date date = getDate(lineParts[2]);
                                    if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                    {
                                        Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                                        querySet.add(event);
                                    }
                                } else
                                {
                                    Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                                    querySet.add(event);
                                }
                            }
                            break;
                    }
                    break;
                case "status":
                    switch (field2)
                    {
                        case "ip":
                        case "user":
                        case "date":
                        case "status":
                            if (value1.equals(lineParts[getField2Index(field2)]))
                            {
                                if (values.size() == 3)
                                {
                                    Date date = getDate(lineParts[2]);
                                    if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                    {
                                        Status status = Status.valueOf(lineParts[4]);
                                        querySet.add(status);
                                    }
                                } else
                                {
                                    Status status = Status.valueOf(lineParts[4]);
                                    querySet.add(status);
                                }
                            }
                            break;
                        case "event":
                            if (value1.equals(lineParts[3].split(" ")[0]))
                            {
                                if (values.size() == 3)
                                {
                                    Date date = getDate(lineParts[2]);
                                    if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                    {
                                        Status status = Status.valueOf(lineParts[4]);
                                        querySet.add(status);
                                    }
                                } else
                                {
                                    Status status = Status.valueOf(lineParts[4]);
                                    querySet.add(status);
                                }
                            }
                            break;
                    }
                    break;
            }
        }
    }
    return querySet;
}
    private int getField2Index(String field2)
    {
        switch (field2)
        {
            case "ip":
                return 0;
            case "user":
                return 1;
            case "date":
                return 2;
            case "event":
                return 3;
            case "status":
                return 4;
        }
        return -1;
    }
}
/*
Давай добавим поддержку параметра запроса в наш QL.
Примеры запросов с параметром:
1)	get ip for user = "Vasya"
2)	get user for event = "DONE_TASK"
3)	get event for date = "03.01.2014 03:45:23"
Общий формат запроса с параметром:
get field1 for field2 = "value1"
Где: field1 - одно из полей: ip, user, date, event или status;
field2 - одно из полей: ip, user, date, event или status;
value1 - значение поля field2.

Алгоритм обработки запроса следующий: просматриваем записи в логе, если поле
field2 имеет значение  value1, то добавляем поле field1 в множество, которое затем
будет возвращено методом execute.

Пример: Вызов метода execute("get event for date = \"30.01.2014 12:56:22\"") должен
вернуть Set<Event>, содержащий только одно событие SOLVE_TASK. Какая именно
задача решалась возвращать не нужно.
 */