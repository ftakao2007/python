class SimpleApp
  def call(env)
    p env
    case env['REQUEST_METHOD']
    when 'GET'
      [
        200,
        { 'Content-Type' => 'text/html' },
        ['<html><body><form method="POST"><input type="submit" value="PUSH" /></form></body></html>']
      ]
    when 'POST'
      [
        200,
        { 'Content-Type' => 'text/html' },
        ['<html><body>:-P</body></html>']
      ]
    end
  end
end
