package by.itacademy.menu;

public abstract class StartBaseMenuItem extends BaseMenuItem {
    private final MenuItem startMenuItem;

    protected StartBaseMenuItem(MenuItem startMenuItem) {
        this.startMenuItem = startMenuItem;
    }

    protected MenuItem startMenuItem() {
        return startMenuItem;
    }

    public void execute() {
        baseExecute();
        startMenuItem().execute();
    }

    protected abstract void baseExecute();

    @Override
    public abstract String name();
}

