#!/usr/bin/env ruby
require 'webrick'

class TestContentServlet < WEBrick::HTTPServlet::AbstractServlet
  def do_GET(req, res)
    res.body = "This is #{req.path}<br>"
    res.content_type = WEBrick::HTTPUtils.mime_type(
      req.path_info,
      WEBrick::HTTPUtils::DefaultMimeTypes)
  end
end

srv = WEBrick::HTTPServer.new(
  :Port => 7777, 
  :BindAddress => "127.0.0.1"
)
srv.mount('/', TestContentServlet)
trap("INT"){ srv.shutdown }

srv.start
