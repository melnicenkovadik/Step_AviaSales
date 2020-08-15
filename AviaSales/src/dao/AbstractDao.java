package dao;

import entity.AbstractEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractDao<T extends AbstractEntity> implements Dao<T> {
    protected List<T> data = new ArrayList<>();
    String fileName;

    public AbstractDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean saveDataToFile() {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(fileName))) {
            this.data.forEach((u) -> {
                try {
                    ous.writeObject(u);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void loadDataFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    this.save((T) ois.readObject());
                } catch (EOFException | ClassNotFoundException e) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("\nДанных нет :(");
        }
    }

    @Override
    public List<T> getAll() {
        return Collections.unmodifiableList(this.data);
    }

    @Override
    public boolean delete(T t) {
        return this.data.remove(t);
    }

    @Override
    public T save(T t) {
        if (this.data.contains(t)) {
            int indexOfElement = this.data.indexOf(t);
            this.data.set(indexOfElement, t);
        } else {
            this.data.add(t);
        }
        return t;
    }
}

