using System.Collections.ObjectModel;
using Avalonia.Controls;
using Avalonia.Interactivity;
using Avalonia.Markup.Xaml;

namespace AvaloniaApp;

public partial class MainWindow : Window
{
    public ObservableCollection<string> Notes { get; } = new ObservableCollection<string>();
    private TextBox? _noteTextBox;

    public MainWindow()
    {
        InitializeComponent();
        DataContext = this;
    }

    private void InitializeComponent()
    {
        AvaloniaXamlLoader.Load(this);
        _noteTextBox = this.FindControl<TextBox>("NoteTextBox");
    }

    private void OnButtonClick(object? sender, RoutedEventArgs e)
    {
        if (_noteTextBox != null)
        {
            var text = _noteTextBox.Text;
            if(!string.IsNullOrWhiteSpace(text))
            {
                Notes.Add(text);
                _noteTextBox.Text = string.Empty;
            }
        }
    }
}
