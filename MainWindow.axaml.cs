using Avalonia.Controls;
using Avalonia.Interactivity;
using Avalonia.Markup.Xaml;

namespace AvaloniaApp;

public partial class MainWindow : Window
{
    public MainWindow()
    {
        InitializeComponent();
    }

    private void InitializeComponent()
    {
        AvaloniaXamlLoader.Load(this);
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
