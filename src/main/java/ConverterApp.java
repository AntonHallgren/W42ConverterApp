void main() {

    UserInterface ui = new UserInterface();
    while(!ui.isExitRequested())
    {
        ui.singleSession();
    }
    IO.println("Goodbye!");
}
