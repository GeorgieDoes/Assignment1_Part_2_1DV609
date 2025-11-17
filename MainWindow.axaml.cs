using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using Avalonia.Controls;
using Avalonia.Interactivity;
using Avalonia.Markup.Xaml;

namespace AvaloniaApp;

public partial class MainWindow : Window
{
    public ObservableCollection<string> Notes { get; } = new ObservableCollection<string>();

    public MainWindow()
    {
        InitializeComponent();
        DataContext = this;
    }

    private void InitializeComponent()
    {
        AvaloniaXamlLoader.Load(this);
    }

    private void OnButtonClick(object? sender, RoutedEventArgs e)
    {
        var text = NoteTextBox.Text;
        if (!string.IsNullOrWhiteSpace(text))
        {
            Notes.Add(text);
            NoteTextBox.Text = string.Empty;
        }
    }
}
