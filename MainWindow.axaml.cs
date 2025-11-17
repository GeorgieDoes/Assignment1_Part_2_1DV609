using Avalonia.Controls;
using Avalonia.Interactivity;

namespace AvaloniaApp;

public partial class MainWindow : Window
{
    public MainWindow()
    {
        InitializeComponent();
    }

    private void OnButtonClick(object? sender, RoutedEventArgs e)
    {
        // Handle button click
        if (sender is Button button)
        {
            button.Content = "Clicked!";
        }
    }
}
