require './spec/mail'

RSpec.describe Mail do
  describe "#score" do
    it "returns 0 for an all gutter mail" do
      mail = Mail.new
      20.times { mail.roll(0) }
      expect(mail.score).to eq(0)
    end
  end
end
